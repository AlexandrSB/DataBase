package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "attr_dic")
public class AttributeDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "attr_group_dic_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private AttributeGroupDictionary attributeGroupDictionary;

}
