package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


@Entity
@Data
@EqualsAndHashCode(of = {"id", "name"})
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@EnableAutoConfiguration
@Table(name = "attribute_value", schema = "public")
public class AttributeValue {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "attribute_value_id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "group_attr_value_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "element_attr_value_id")
    private Element element;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;
}
