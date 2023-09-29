package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "goods_tracking_from_contragent", schema = "public")
public class GoodsTrackingFromContragent {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_goods_movement")
    private TypeOfGoodsMovement typeOfGoodsMovement;

    @OneToMany(mappedBy = "goodsTrackingFromContragent")
    private Set<Party> parties = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "contragent_id")
    private Contragent contragent;

    @ManyToOne
    @JoinColumn(name = "goods_tracking_date_id")
    private GoodsTrackingDate goodsTrackingDate;

    public Set<Party> addParty(Party party) {
        this.parties.add(party);

        return this.parties;
    }
}
