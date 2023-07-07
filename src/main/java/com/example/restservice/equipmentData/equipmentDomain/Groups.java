package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Table(name = "groups", schema = "public")
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "group_id", nullable = false)
    private Long id;

    @NonNull
    @Column(name = "group_name")
    private String groupName;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Equipment> equipmentGroup = new HashSet<>();

    public void addEquipment(Equipment equipment) {
        equipmentGroup.add(equipment);
    }

    public void addEquipments(List<Equipment> equipment) {
        equipmentGroup.addAll(equipment);
    }
}
