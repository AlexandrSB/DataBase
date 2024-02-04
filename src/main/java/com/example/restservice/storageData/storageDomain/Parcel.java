package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(onlyExplicitlyIncluded=true)
@Table(name = "parcel", schema = "public")
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ToString.Include
    private Long id;

    @ToString.Include
    private String name;

    @ToString.Include
    @Column(name = "proxy_id")
    private Long proxyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "good_id")
    private Good good;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "party_id")
    private Party party;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quantity_account_id")
    private QuantityAccount quantityAccount;

//    @Override
//    public String toString() {
//        return String.format("To String() class Parcel id = %s", this.id);
//    }
}
