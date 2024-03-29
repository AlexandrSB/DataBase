package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.TimeZoneColumn;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "repair_card_of_equipment")
public class RepairCardOfEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "equipment_name")
    private String equipmentName;

    @Column(name = "repair_type")
    private  RepairType repairType;

    @CurrentTimestamp
    @Column(name = "begin_repair_timestamp")
    private ZonedDateTime beginRepairTimestamp;

    @TimeZoneColumn
    @Column(name = "end_repair_timestamp")
    private ZonedDateTime endRepairTimestamp;

    @ManyToOne
    @JoinColumn(name = "workshop_element_id")
    private WorkshopElement workshopElement;

    @OneToMany(mappedBy = "repairCardOfEquipment")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<RepairCardOfModule> repairCardOfModules;
}
