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

    @ManyToOne
    @JoinColumn(name = "quantity_id")
    private Quantity dimension;

    @OneToMany(mappedBy = "quantityAccount")
    private Set<Parcel> parcels = new HashSet<>();

}
