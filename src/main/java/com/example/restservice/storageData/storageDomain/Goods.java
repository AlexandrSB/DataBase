package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor(force = true)
@Table(name = "goods", schema = "public")
public class Goods {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column( name = "id", nullable = false, unique = true )
    private Long id;

    @Column( name = "name", nullable = false )
    private String name;

    @OneToOne
    private Barcode barcode;

    @ManyToOne
    @JoinColumn(name = "fixed_card_id")
    private FixedCard fixedCard;

    @ManyToMany( fetch = FetchType.EAGER )
    @JoinTable(
            name = "storage_goods",
            joinColumns = {
                    @JoinColumn( name = "goods_id" )
            },
            inverseJoinColumns = {
                    @JoinColumn( name = "storage_id" )
            }
    )
    private Set<Storage> storages = new HashSet<>();
}