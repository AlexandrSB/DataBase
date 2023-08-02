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

@Entity
@Data
@EqualsAndHashCode(of = {"id", "date", "type"})
@NoArgsConstructor(force = true)
//@RequiredArgsConstructor(onConstructor = @__( @Autowired))
@EnableAutoConfiguration
@Table(name = "movement_goods", schema = "public")
public class Goods {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column( name = "data" )
    private Date date;

    @Column(name = "type" )
    private String type;

    @Column( name = "barcode" )
    private Integer barcode;
    @ManyToMany( mappedBy = "id", cascade = { CascadeType.PERSIST })
    private Set<Contragent> contragents = new HashSet<>();

    @ManyToMany( mappedBy = "id", cascade = { CascadeType.PERSIST })
    private Set< Storage > storage = new HashSet<>();
}
