package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Entity
@Data
@Table(name = "workshop_equipment")
public class WorkshopElement {

    @Id
    private Long id;

    @Column(name = "inventory_number")
    private String inventoryNumber;

    @OneToMany(mappedBy = "workshopElement")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<RepairCardOfEquipment> repairCardOfEquipments;

    @OneToMany(mappedBy = "workshopElement")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<WorkshopModule> workshopModules;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private WorkshopEquipment workshopEquipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proxy_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private WorkshopProxy workshopProxy;
}
