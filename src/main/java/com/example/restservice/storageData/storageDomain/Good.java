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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "condition_id")
    private Condition condition;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "good_equip",
            joinColumns = {
                @JoinColumn(
                        name = "good_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(
                        name = "equipment_id", referencedColumnName = "id")
            }
    )
    private Equipment equipment;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "goods_party",
            joinColumns = {
                    @JoinColumn(
                            name = "good_id"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "party_id"
                    )
            }
    )
    private Set<Party> parties = new HashSet<>();
}
