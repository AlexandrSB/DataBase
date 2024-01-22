package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "workshop_equipment")
public class WorkshopEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String model;

    private String type;

    @Column(name = "inventory_number")
    private String inventoryNumber;

    @OneToOne
    private RepairCard repairCard;
}
