package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "unit_dic", schema = "public")
public class UnitDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "unitDictionary")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Unit> units = new HashSet<>();
}
