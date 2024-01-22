package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Entity
@Data
@Table(name = "type_of_repair")
public class TypeOfRepair {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "repair_type")
    private String repairType;

    @OneToMany(mappedBy = "typeOfRepair")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<CompletedWork> completedWorks;
}
