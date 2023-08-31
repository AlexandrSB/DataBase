package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class QuantityAccount {

    @Id
    @GeneratedValue
    private Long id;

    private Integer quantity;

    @OneToMany(mappedBy = "quantityAccount")
    private Set<Quantity> quantities = new HashSet<>();

    @OneToMany(mappedBy = "quantityAccount")
    private Set<PartyFromContragent> partyFromContragents = new HashSet<>();

    @OneToMany(mappedBy = "quantityAccount")
    private Set<PartyFromStorage> partyFromStorages = new HashSet<>();
}
