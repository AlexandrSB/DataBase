package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "repair_card_of_module")
public class RepairCardOfModule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "workshop_module_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private WorkshopModule workshopModule;

    @ManyToOne
    @JoinColumn(name = "repair_card_of_equipment_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private RepairCardOfEquipment repairCardOfEquipment;

    @OneToMany(mappedBy = "repairCardOfModule")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ConsumptionOfMaterial> consumptionOfMaterials;
}
