package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "repair_notation")
public class RepairNotation {

    @Id
    @GeneratedValue
    private Long id;

    private String notation;

    @ManyToMany
    @JoinTable(
            name = "model_repair_notation",
            joinColumns = @JoinColumn(name = "repair_notation_id"),
            inverseJoinColumns = @JoinColumn(name = "model_id")
    )
    private Set<Model> models = new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "repair_repair_notation",
            joinColumns = @JoinColumn(name = "repair_notation_id"),
            inverseJoinColumns = @JoinColumn(name = "repair_id")
    )
    private Set<Repair> repairSet = new HashSet<>();

    public void addModel(Model model) {
        models.add(model);
    }
}
