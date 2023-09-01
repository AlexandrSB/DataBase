package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "quantity", schema = "public")
public class Quantity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "dimension")
    private String dimension;

    @Column(name = "quantity_in_one")
    private Integer quantityInOne;

    @ManyToOne
    @JoinColumn(name = "quantity_account_id")
    private QuantityAccount quantityAccount;
}
