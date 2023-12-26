package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor(force = true)
public class Good {

    @Id
    @GeneratedValue
    private final Long id;

    private String name;

    private Set<Long> proxy_id = new HashSet<>();

    @Column(name = "external_equip_id")
    private Long externalEquipId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "good_equip",
//            joinColumns = {
//                @JoinColumn(
//                        name = "good_id", referencedColumnName = "id")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(
//                        name = "equipment_id", referencedColumnName = "id")
//            }
//    )
    @OneToMany(mappedBy = "good", fetch = FetchType.LAZY)
    private Set<Equipment> equipment = new HashSet<>();

    @OneToMany(mappedBy = "good", fetch = FetchType.LAZY)
    private Set<Parcel> parcels = new HashSet<>();

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", proxy_id=" + proxy_id +
                ", externalEquipId=" + externalEquipId +
                '}';
    }
}
