package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "equipment", schema = "public")
public class WorkshopEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
}
