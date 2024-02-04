package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Model {

    @Id
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "model_repair_notation",
            joinColumns = @JoinColumn(name = "model_id"),
            inverseJoinColumns = @JoinColumn(name = "repair_notation_id")
    )
    private Set<RepairNotation> repairNotationSet = new HashSet<>();

    @OneToMany(mappedBy = "model")
    private Set<Equipment> equipmentSet = new HashSet<>();
}
