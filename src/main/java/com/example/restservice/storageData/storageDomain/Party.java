package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor(force = true)
public class Party {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne()
    @JoinColumn(name = "goods_tracking_from_contragent_id")
    private GoodsTrackingFromContragent goodsTrackingFromContragent;

    @ManyToOne()
    @JoinColumn(name = "goods_tracking_from_storage_id")
    private GoodsTrackingFromStorage goodsTrackingFromStorage;

    @ManyToMany(mappedBy = "parties", fetch = FetchType.EAGER)
    private Set<Good> goods = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "quantity_id")
    private QuantityAccount quantityAccount;
}
