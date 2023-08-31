package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PartyFromStorage {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeOfGoodsMovement typeOfGoodsMovement;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private GoodsTrackingFromStorage goodsTrackingFromStorage;

    @ManyToOne
    @JoinColumn(name = "good_id")
    private Good good;

    @ManyToOne
    @JoinColumn(name = "quantity_account")
    private QuantityAccount quantityAccount;
}
