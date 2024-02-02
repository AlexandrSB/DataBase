package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor(force = true)
@Table(name = "attribute", schema = "public")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "attribute")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<AttributeGroup> attributeGroups = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "attr_value_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private AttributeValue attributeValue;

    public Attribute(String n) {
        this.name = n;
    }
}
