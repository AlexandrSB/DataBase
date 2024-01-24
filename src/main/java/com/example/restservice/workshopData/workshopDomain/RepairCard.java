package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;

import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "repair_card")
public class RepairCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "repair_type")
    private  RepairType repairType;

    @CurrentTimestamp
    @Column(name = "begin_repair_timestamp")
    private ZonedDateTime beginRepairTimestamp;

    @TimeZoneStorage(TimeZoneStorageType.NATIVE)
    @Column(name = "end_repair_timestamp")
    private ZonedDateTime endRepairTimestamp;

    @OneToMany(mappedBy = "repairCard")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<WorkshopModule> workshopModules;

    @OneToOne
    @JoinColumn(name = "workshop_equipment_id")
    private WorkshopEquipment workshopEquipment;
}
