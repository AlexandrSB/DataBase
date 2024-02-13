package com.example.restservice.storageData.storageDomain;

import com.example.restservice.equipmentData.equipmentDomain.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor(force = true)
public class Good {

    @Id
//    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "category")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quantity_account_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private QuantityAccount quantityAccount;

    @OneToMany(mappedBy = "good", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Equipment> equipment = new HashSet<>();

    @OneToMany(mappedBy = "good", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Parcel> parcels = new HashSet<>();

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", proxy_id=" + proxy_id +
//                ", externalEquipId=" + externalEquipId +
                '}';
    }
}
