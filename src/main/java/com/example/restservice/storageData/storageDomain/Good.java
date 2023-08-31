package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Good {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "good_equip",
            joinColumns = {
                @JoinColumn(name = "good_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
            }
    )
    private Equipment equipment;

    @OneToMany(mappedBy = "good")
    private Set<PartyFromContragent> parties = new HashSet<>();
}
