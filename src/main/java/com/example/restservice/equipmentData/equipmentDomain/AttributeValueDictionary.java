package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "attr_value_dic")
public class AttributeValueDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "attr_dic_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private AttributeDictionary attributeDictionary;

}
