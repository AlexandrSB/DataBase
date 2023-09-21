package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "dimension", fetch = FetchType.EAGER)
    private Set<QuantityAccount> quantityAccounts = new HashSet<>();
}
