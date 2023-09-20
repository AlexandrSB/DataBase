package com.example.restservice.storageData.storageDomain;

import com.example.restservice.equipmentData.equipmentDomain.Proxy;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor(force = true)
@Table(name = "party", schema = "public")
public class Party {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "proxy_list")
    private List<String> proxyList = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "goods_tracking_from_contragent_id")
    private GoodsTrackingFromContragent goodsTrackingFromContragent;

    @ManyToOne()
    @JoinColumn(name = "goods_tracking_from_storage_id")
    private GoodsTrackingFromStorage goodsTrackingFromStorage;

    @ManyToMany(mappedBy = "parties", fetch = FetchType.LAZY)
    private Set<Good> goods = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "quantity_id")
    private QuantityAccount quantityAccount;

    public List addProxy(String proxy_name) {
        this.proxyList.add(proxy_name);

        return this.proxyList;
    }

    public Set<Good> addGood(Good good) {
        this.goods.add(good);

        return this.goods;
    }
}
