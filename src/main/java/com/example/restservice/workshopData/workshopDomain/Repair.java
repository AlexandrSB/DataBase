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

    private RepairType repairType;

    private String notation;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    public Equipment equipment_id;

    @ManyToMany
    public Set<Spares> spares = new HashSet<>();
}
