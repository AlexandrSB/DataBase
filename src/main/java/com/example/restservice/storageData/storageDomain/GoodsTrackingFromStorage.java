package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "goods_tracking_from_storage", schema = "public")
public class GoodsTrackingFromStorage {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_goods_movement")
    private TypeOfGoodsMovement typeOfGoodsMovement;

    @OneToOne(mappedBy = "goodsTrackingFromStorage", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PartyFromStorage partyFromStorage;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;

    @ManyToOne
    @JoinColumn(name = "goods_tracking_date_id")
    private GoodsTrackingDate goodsTrackingDate;
}
