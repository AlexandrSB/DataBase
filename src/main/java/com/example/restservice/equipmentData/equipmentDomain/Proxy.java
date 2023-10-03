package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor(force = true)
@Table(name = "proxy", schema = "public")
public class Proxy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "element_proxy",
            joinColumns = {
                    @JoinColumn(name = "proxy_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "element_id")
            }
    )
    private Set<Element> elements = new HashSet<>();

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "firma_id")
    private Firma firma;

    @ToString.Exclude
    @OneToMany(mappedBy = "proxy")
    private Set<AttributeValue> attributeValues = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "proxy")
    private Set<ElementsComposite> elementsComposites = new HashSet<>();
}
