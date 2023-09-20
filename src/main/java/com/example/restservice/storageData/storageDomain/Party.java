package com.example.restservice.storageData.storageDomain;

import com.example.restservice.equipmentData.equipmentDomain.Proxy;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor(force = true)
@Table(name = "party", schema = "public")
public class Party {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne()
    @JoinColumn(name = "goods_tracking_from_contragent_id")
    private GoodsTrackingFromContragent goodsTrackingFromContragent;

    @ManyToOne()
    @JoinColumn(name = "goods_tracking_from_storage_id")
    private GoodsTrackingFromStorage goodsTrackingFromStorage;

    @ManyToOne
    @JoinColumn(name = "parcel_id")
    private Parcel parcel;

}