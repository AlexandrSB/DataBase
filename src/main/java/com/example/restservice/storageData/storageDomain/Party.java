package com.example.restservice.storageData.storageDomain;

import com.example.restservice.equipmentData.equipmentDomain.Proxy;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.repository.Query;

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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_tracking_from_contragent_id")
    private GoodsTrackingFromContragent goodsTrackingFromContragent;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_tracking_from_storage_id")
    private GoodsTrackingFromStorage goodsTrackingFromStorage;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "party")
    private Set<Parcel> parcels = new HashSet<>();

    public Set<Parcel> addParcel(Parcel parcel) {
        this.parcels.add(parcel);
        return this.parcels;
    }

//    public String toString() {
//        return String.format("class Party id = %s, name = %s",
//                this.getId(), this.getName());
//    }
}