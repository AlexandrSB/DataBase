package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "completed_work")
public class CompletedWork {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String notation;

    @OneToMany(mappedBy = "completedWork")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ConsumptionOfMaterials> consumptionOfMaterials;

    @OneToMany(mappedBy = "completedWork")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<TypeOfOperation> typeOfOperations = new HashSet<>();

    @Column(name = "repair_type")
    private RepairType repairType;

}
