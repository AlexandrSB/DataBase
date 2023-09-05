package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "quantity_account", schema = "public")
public class QuantityAccount {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "quantityAccount")
    private Set<Quantity> quantities = new HashSet<>();

    @OneToMany(mappedBy = "quantityAccount")
    private Set<Party> party = new HashSet<>();
}
