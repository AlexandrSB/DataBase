package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "parcel", schema = "public")
public class Parcel {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "good_id")
    private Good good;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quantity_account_id")
    private QuantityAccount quantityAccount;

    @OneToMany(mappedBy = "parcel")
    private Set<Party> parties = new HashSet<>();

}
