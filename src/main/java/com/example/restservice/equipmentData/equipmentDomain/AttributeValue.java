package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@EqualsAndHashCode(of = {"id", "name"})
@NoArgsConstructor(force = true)
@Table(name = "attribute_value", schema = "public")
public class AttributeValue {

    @Id
//    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attr_value_dic_id")
    @ToString.Exclude
    private AttributeValueDictionary attributeValueDictionary;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    @ToString.Exclude
    private Attribute attribute;

    @OneToOne(mappedBy = "attributeValue")
    @ToString.Exclude
    private Unit unit;

}
