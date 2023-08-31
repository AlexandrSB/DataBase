package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "storage")
    private Set<GoodsTrackingFromContragent> goodsTrackingFromContragents = new HashSet<>();

    @OneToMany(mappedBy = "storage")
    private Set<GoodsTrackingFromStorage> goodsTrackingFromStorages = new HashSet<>();
}
