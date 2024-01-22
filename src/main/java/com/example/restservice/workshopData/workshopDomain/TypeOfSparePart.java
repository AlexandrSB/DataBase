package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "type_of_spare_part")
public class TypeOfSparePart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "spare_part")
    private SparePart sparePart;
}
