package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Entity
@Data
@Table(name = "workshop_module")
public class WorkshopModule {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private WorkshopUnit workshopUnit;

    @OneToMany(mappedBy = "workshopModule")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ConsumptionOfMaterial> consumptionOfMaterials;

    @OneToMany(mappedBy = "workshopModule")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<RepairCardOfModule> repairCardOfModules;
}
