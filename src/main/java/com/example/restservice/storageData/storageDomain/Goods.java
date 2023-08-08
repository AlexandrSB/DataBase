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
@EqualsAndHashCode(of = {"id", "date", "type"})
@NoArgsConstructor(force = true)
@Table(name = "goods", schema = "public")
public class Goods {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column( name = "id", nullable = false )
    private Long id;

    @Column( name = "data" )
    private Date date;

    @Column( name = "type" )
    private String type;

    @Column( name = "barcode " )
    private Integer barcode;

    @ManyToMany
    @JoinTable(
            name = "contragent_goods",
            joinColumns = {
                    @JoinColumn( name = "goods_id" )
            },
            inverseJoinColumns = {
                    @JoinColumn( name = "contragent_id" )
            }
    )
    private Set <Contragent> contragents = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "goods_storage",
            joinColumns = {
                    @JoinColumn(name="goods_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name="storage_id")
            }
    )
    private Set <Storage> storage = new HashSet<>();
}
