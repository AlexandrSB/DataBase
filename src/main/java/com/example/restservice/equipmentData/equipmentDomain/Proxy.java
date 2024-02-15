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

    @Column(name = "description", length = 5000)
    private String description;

    @Column(name = "category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "parent_module_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Element module;

    @ManyToOne
    @JoinColumn(name = "proxy_type_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ElementType elementType;

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
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Element> elements = new HashSet<>();

    @OneToMany(mappedBy = "proxy")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ElementsComposite> elementsComposites =
            new HashSet<>();


    @OneToMany(mappedBy = "proxy")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<AttributeGroup> attributeGroups = new HashSet<>();
}
