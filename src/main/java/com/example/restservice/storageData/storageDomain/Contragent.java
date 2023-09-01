package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name="contragent", schema = "public")
public class Contragent {

    @Id
    @GeneratedValue
    private Long id;

    @Column( name = "name" )
    private String name;

    @Column( name = "description" )
    private String description;

    @OneToMany( mappedBy = "contragent", fetch = FetchType.EAGER )
    private Set<GoodsTrackingFromContragent> goodsTracingFromContragentSet = new HashSet<>();
}
