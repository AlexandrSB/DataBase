package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "element_type", schema = "public")
//TODO определиться с записью типа элемента
public class ElementType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String type;

}
