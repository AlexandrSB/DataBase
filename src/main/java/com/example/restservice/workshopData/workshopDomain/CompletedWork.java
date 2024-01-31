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

    @Column(name = "repair_type")
    private RepairType repairType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_of_spare_part_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public TypeOfSparePart typeOfSparePart;

    @OneToMany(mappedBy = "completedWork")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ConsumptionOfMaterial> consumptionOfMaterials;

    @OneToMany(mappedBy = "completedWork")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<TypeOfOperation> typeOfOperations = new HashSet<>();

}
