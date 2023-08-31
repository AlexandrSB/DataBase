package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PartyFromContragent {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne()
    @MapsId
    @JoinColumn(name = "id")
    private GoodsTrackingFromContragent goodsTrackingFromContragent;

    @ManyToOne
    @JoinColumn(name = "good_id")
    private Good good;

    @ManyToOne
    @JoinColumn(name = "quantity_account")
    private QuantityAccount quantityAccount;
}
