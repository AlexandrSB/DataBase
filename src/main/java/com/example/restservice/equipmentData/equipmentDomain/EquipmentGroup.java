package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(force = true)
@Table(name = "equipment_group", schema = "public")
public class EquipmentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NonNull
    private String groupName;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Equipment> equipmentGroup = new HashSet<>();

    public void addEquipment(Equipment equipment) {
        equipmentGroup.add(equipment);
    }

    public void addEquipments(List<Equipment> equipment) {
        equipmentGroup.addAll(equipment);
    }
}
