package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Quantity {

    @Id
    @GeneratedValue
    private Long id;

    private String dimension;

    private Integer quantityInOne;

    @ManyToOne
    @JoinColumn(name = "quantity_account_id")
    private QuantityAccount quantityAccount;
}
