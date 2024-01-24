package com.example.restservice.workshopData.workshopDomain;

import com.example.restservice.workshopData.workshopRepos.RepairCardOfModuleRepo;
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

    @Column(name = "repair_type")
    private  RepairType repairType;

    @CurrentTimestamp
    @Column(name = "begin_repair_timestamp")
    private ZonedDateTime beginRepairTimestamp;

    @TimeZoneColumn
    @Column(name = "end_repair_timestamp")
    private ZonedDateTime endRepairTimestamp;

    @ManyToOne
    @JoinColumn(name = "workshop_equipment_id")
    private WorkshopEquipment workshopEquipment;

    @OneToMany(mappedBy = "repairCardOfEquipment")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<RepairCardOfModule> repairCardOfModules;
}
