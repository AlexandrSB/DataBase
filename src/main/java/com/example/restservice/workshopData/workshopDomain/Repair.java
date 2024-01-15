package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
public class Repair {

    @Id
    @GeneratedValue
    public Long id;

    @CurrentTimestamp
    private Timestamp timestamp;

    @Column(name = "repair_type")
    private RepairType repairType;

    @ManyToMany
    @JoinTable(
            name = "repair_repair_notation",
            joinColumns = @JoinColumn(name = "repair_id"),
            inverseJoinColumns = @JoinColumn(name = "repair_notation_id")
    )
    private Set<RepairNotation> repairNotations;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    public Equipment equipment_id;

    @OneToMany(mappedBy = "repair")
    public Set<NumberOfSparesParts> numberOfSparesParts = new HashSet<>();
}
