package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "type_of_spare_part")
public class TypeOfSparePart {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "spare_part_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private SparePart sparePart;
}
