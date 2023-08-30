package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
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

    @ToString.Exclude
    @OneToMany(
            mappedBy = "contragent",
            fetch = FetchType.EAGER
    )

    private Set<GoodsTracking> goodsTrackings;
}
