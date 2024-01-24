package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Entity
@Data
@Table(name = "workshop_equipment")
public class WorkshopEquipment {

    @Id
    private Long id;

    private String model;

    private String type;

    @Column(name = "inventory_number")
    private String inventoryNumber;

    @OneToMany(mappedBy = "workshopEquipment")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<RepairCardOfEquipment> repairCardOfEquipments;

}
