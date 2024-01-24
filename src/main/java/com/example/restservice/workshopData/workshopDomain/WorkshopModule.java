package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "workshop_module")
public class WorkshopModule {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "consumption_of_materials_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ConsumptionOfMaterials consumptionOfMaterials;

    @ManyToOne
    @JoinColumn(name = "repair_card_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private RepairCard repairCard;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private WorkshopUnit workshopUnit;

}
