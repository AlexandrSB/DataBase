package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "good", schema = "public")
public class Good {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "external_equip_id")
    private Long external_equip_id;

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

    @OneToMany(mappedBy = "good", fetch = FetchType.EAGER)
    private Set<PartyFromContragent> parties = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "condition_id")
    private Condition condition;
}
