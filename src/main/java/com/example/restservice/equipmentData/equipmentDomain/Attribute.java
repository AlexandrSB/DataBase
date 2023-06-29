package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "attribute_id")
    private Integer id;

    @NonNull
    @Setter
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @NonNull
    @Setter
    private EnumUnits unit;

    @ManyToMany
    @JoinTable(
            name = "component_attribute",
            joinColumns = { @JoinColumn(name = "attr_id") },
            inverseJoinColumns = { @JoinColumn(name = "comp_id") }
    )
    private Set<Component> components = new HashSet<>();

    @Setter
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AttributeStringValue> strValues;

    @Setter
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AttributeIntegerValue> intValues;

    public Attribute(String n) {
        this.name = n;
    }

    public void addComponent(Component comp) {
        components.add(comp);
    }

    public void addValues(String str) {
        AttributeStringValue attributeStringValue = new AttributeStringValue(str);
        strValues.add(attributeStringValue);
    }
}
