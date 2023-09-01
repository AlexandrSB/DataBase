package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "goods_tracking_date", schema = "public")
public class GoodsTrackingDate {

    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    @Column(name = "created_on")
    private ZonedDateTime createdOn;

    @OneToMany(mappedBy = "goodsTrackingDate")
    private Set<GoodsTrackingFromContragent> goodsTrackingFromContragents = new HashSet<>();

    @OneToMany(mappedBy = "goodsTrackingDate")
    private Set<GoodsTrackingFromStorage> goodsTrackingFromStorages = new HashSet<>();
}
