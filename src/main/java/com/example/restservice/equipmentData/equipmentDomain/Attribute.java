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
@Table(name = "attribute", schema = "public")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "attribute_id")
    private Long id;

    @NonNull
    @Setter
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "attr_value_id")
    private AttributeValue attr_value_id;

////    @NonNull
////    @Setter
////    private Unit unit;
//
//    @ManyToMany
//    @JoinTable(
//            name = "component_attribute",
//            joinColumns = { @JoinColumn(name = "attr_id") },
//            inverseJoinColumns = { @JoinColumn(name = "comp_id") }
//    )
//    private Set<Element> elements = new HashSet<>();
//
//    @Setter
//    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<AttributeStringValue> strValues;
//
//    @Setter
//    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<AttributeIntegerValue> intValues;

    public Attribute(String n) {
        this.name = n;
    }

//    public void addComponent(Element comp) {
//        elements.add(comp);
//    }
//
//    public void addValues(String str) {
//        AttributeStringValue attributeStringValue = new AttributeStringValue(str);
//        strValues.add(attributeStringValue);
//    }
}
