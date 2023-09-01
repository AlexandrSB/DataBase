package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "workshop", schema = "public")
public class Workshop {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private String notice;

    @OneToMany(mappedBy = "workshop")
    private Set<GoodsTrackingFromStorage> goodsTrackingFromStorages = new HashSet<>();
}
