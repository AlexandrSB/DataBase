package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class GoodsTrackingDate {

    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    private ZonedDateTime createdOn;

    @OneToMany(mappedBy = "goodsTrackingDate")
    private Set<GoodsTrackingFromContragent> goodsTrackingFromContragents = new HashSet<>();

    @OneToMany(mappedBy = "goodsTrackingDate")
    private Set<GoodsTrackingFromStorage> goodsTrackingFromStorages = new HashSet<>();
}
