package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "attribute_group", schema = "public")
public class AttributeGroup {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "proxy_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Proxy proxy;

    @ManyToOne
    @JoinColumn(name = "attr_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Attribute attribute;
}
