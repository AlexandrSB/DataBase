package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor(force = true)
@Table(name = "barcode", schema = "public")
public class Dimension {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dimension")
    private String dimension;

    @OneToOne
    private Dimension parentId;

    @ManyToMany
    @JoinTable(
            name = "dimension_goods",
            joinColumns = {
                    @JoinColumn(name = "dimension_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "goods_id")
            }
    )
    private Set<Goods> goods = new HashSet<>();
}
