package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "consumption_of_material")
public class ConsumptionOfMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "quantity_of_material")
    private Integer quantityOfMaterial;

    @ManyToOne
    @JoinColumn(name = "type_of_spare_part_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private TypeOfSparePart typeOfSparePart;

    @ManyToOne
    @JoinColumn(name = "workshop_module_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private WorkshopModule workshopModule;

    @ManyToOne
    @JoinColumn(name = "completed_work_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private CompletedWork completedWork;

    @ManyToOne
    @JoinColumn(name = "repair_card_of_module_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private RepairCardOfModule repairCardOfModule;
}
