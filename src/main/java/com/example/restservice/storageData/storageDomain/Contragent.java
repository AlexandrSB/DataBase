package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(of = {"id", "name", "description"})
@NoArgsConstructor(force = true)
@Table(name = "contragent", schema = "public")
public class Contragent {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column( name = "name" )
    private String name;

    @Column( name = "description" )
    private String description;

    @ManyToMany
    @JoinTable(
            name = "contragent_goods",
            joinColumns = { @JoinColumn( name = "goods_id" )},
            inverseJoinColumns = { @JoinColumn( name = "contragent_id" )}
    )
    private Set< Goods > goods = new HashSet<>();
}
