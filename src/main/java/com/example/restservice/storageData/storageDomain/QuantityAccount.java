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

    @OneToMany(mappedBy = "quantityAccount", fetch = FetchType.EAGER)
    private Set<Quantity> quantities = new HashSet<>();

    @OneToMany(mappedBy = "quantityAccount", fetch = FetchType.EAGER)
    private Set<Party> parties = new HashSet<>();

    public Set<Quantity> addDimension(Quantity quantity) {
        this.quantities.add(quantity);

        return this.quantities;
    }

    public Set<Party> addParty(Party party) {
        this.parties.add(party);

        return this.parties;
    }
}
