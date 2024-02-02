package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(force = true)
@EqualsAndHashCode(of = {"id", "name"})
@Table(name = "attribute", schema = "public")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "attribute_group_id")
    private AttributeGroup attributeGroup;

    public Attribute(String n) {
        this.name = n;
    }
}
