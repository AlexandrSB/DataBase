package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


@Entity
@Data
@EqualsAndHashCode(of = {"id", "name"})
@NoArgsConstructor(force = true)
@Table(name = "attribute_value", schema = "public")
public class AttributeValue {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "proxy_id")
    private Proxy proxy;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;
}
