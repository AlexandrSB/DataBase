package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Storage {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "storage", fetch = FetchType.EAGER)
    private Set<GoodsTrackingFromContragent> goodsTrackingFromContragents = new HashSet<>();

    @OneToMany(mappedBy = "storage", fetch = FetchType.EAGER)
    private Set<GoodsTrackingFromStorage> goodsTrackingFromStorages = new HashSet<>();
}
