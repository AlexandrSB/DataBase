package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "spare_part")
public class SparePart {

    @Id
    public Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "workshop_unit_id")
    private WorkshopUnit workshopUnit;

    @OneToMany(mappedBy = "sparePart")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<TypeOfSparePart> typeOfSparePartSet = new HashSet<>();

    public SparePart addTypeOfSparePart(TypeOfSparePart tosp) {
        this.typeOfSparePartSet.add(tosp);
        return this;
    }
}
