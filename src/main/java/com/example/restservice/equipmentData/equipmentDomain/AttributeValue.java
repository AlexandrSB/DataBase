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
@Table(name = "attribute_value", schema = "public")
public class AttributeValue {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "attr_value_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "group_attr_value_id")
//    private Group group;

    @ManyToOne
    @JoinColumn(name = "element_attr_value_id")
    private Element element;

    @ManyToOne
    @JoinColumn(name = "unit_attr_value_id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "attribute_attr_value_id")
    private Attribute attribute;
}
