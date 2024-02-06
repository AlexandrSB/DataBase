package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "attribute_group", schema = "public")
public class AttributeGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "attr_group_dic_id")
    @ToString.Exclude
    private AttributeGroupDictionary attributeGroupDictionary;

    @ManyToOne
    @JoinColumn(name = "proxy_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Proxy proxy;

    @OneToMany(mappedBy = "attributeGroup")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Attribute> attributes = new HashSet<>();

    public void addAttributes(Attribute attribute) {
        this.attributes.add(attribute);
    }
}
