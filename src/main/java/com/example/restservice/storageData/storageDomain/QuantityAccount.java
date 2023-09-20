package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor(force = true)
@Table(name = "quantity_account", schema = "public")
public class QuantityAccount {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "quantityAccount", fetch = FetchType.LAZY)
    private Set<Quantity> quantities = new HashSet<>();

    @OneToMany(mappedBy = "quantityAccount")
    private Set<Parcel> parcels = new HashSet<>();

    public Set<Quantity> addDimension(Quantity quantity) {
        this.quantities.add(quantity);
        return this.quantities;
    }

}
