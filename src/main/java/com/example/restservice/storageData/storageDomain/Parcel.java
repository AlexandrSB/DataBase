package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "parcel", schema = "public")
public class Parcel {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "good_id")
    private Good good;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "party_id")
    private Party party;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quantity_account_id")
    private QuantityAccount quantityAccount;

    @Override
    public String toString() {
        return String.format("To String() class Parcel id = %s", this.id);
    }
}
