package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor(force = true)
@Table(name = "barcode", schema = "public")
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany
    private Set<GoodsTracking> goodsTrackings;

    @OneToMany
    private Set<Goods> goods;
}
