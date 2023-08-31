package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class GoodsTrackingFromContragent {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeOfGoodsMovement typeOfGoodsMovement;

    @OneToOne(mappedBy = "goodsTrackingFromContragent", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private final PartyFromContragent partyFromContragent;

    @ManyToOne
    @JoinColumn(name = "contragent_id")
    private Contragent contragent;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "goods_tracking_date_id")
    private GoodsTrackingDate goodsTrackingDate;
}
