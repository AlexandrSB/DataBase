package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@Data
@Table(name = "workshop_element", schema = "public")
public class WorkshopElement {

    @Id
    private Long id;

    // TODO занести в базу данных
    @Column(name = "prefix_inventory_number")
    private String prefixInventoryNumber;

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
