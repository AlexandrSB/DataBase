package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "workshop_module")
public class WorkshopModule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "workshop_unit_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private WorkshopUnit workshopUnit;

    @ManyToOne
    @JoinColumn(name = "workshop_element_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private WorkshopElement workshopElement;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workshopModule")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ConsumptionOfMaterial> consumptionOfMaterials;

    @OneToMany(mappedBy = "workshopModule")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<RepairCardOfModule> repairCardOfModules;
}
