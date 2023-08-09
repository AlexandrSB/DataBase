package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(of = {"id", "name"})
@NoArgsConstructor(force = true)
@Table(name = "goods", schema = "public")
public class Goods {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column( name = "id", nullable = false, unique = true )
    private Long id;

    @Column( name = "name", nullable = false )
    private String name;

    @Column( name = "inventory_number" )
    private String inventoryNumber;

    @Column( name = "description" )
    private String description;

    @Column( name = "barcode" )
    private Integer barcode;

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

    @ManyToOne
    private Condition condition;
}