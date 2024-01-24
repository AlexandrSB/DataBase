package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "unit")
public class WorkshopUnit {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "workshopUnit")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<TypeOfOperation> typeOfOperations = new HashSet<>();

    @OneToMany(mappedBy = "workshopUnit")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<SparePart> spareParts = new HashSet<>();

    @OneToMany(mappedBy = "workshopUnit")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<WorkshopModule> workshopModules = new HashSet<>();

}
