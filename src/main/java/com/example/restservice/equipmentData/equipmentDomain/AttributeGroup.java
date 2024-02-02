package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "attribute_group", schema = "public")
public class AttributeGroup {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    private String name;
}
