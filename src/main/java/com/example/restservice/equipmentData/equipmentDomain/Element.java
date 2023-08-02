package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(of = {"id", "name"})
@NoArgsConstructor(force = true)
@Table(name = "component", schema = "public")
public class Element {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    @Column(name = "element_id", nullable = false, unique = true)
    private Long id;

//    @ManyToMany
//    @JoinTable(
//            name = "element_groups",
//            joinColumns = { @JoinColumn(name = "element_id")},
//            inverseJoinColumns = { @JoinColumn(name = "group_id")}
//    )
//    private Set<Element> owner = new HashSet<>();

    @NonNull
    @Setter
    @Column(name = "name", unique = true, nullable = false)
    private String name;

//    @ManyToOne
//    @JoinTable( name = "attribute_value",
//            joinColumns = {@JoinColumn(name = "comp_id")},
//            inverseJoinColumns = { @JoinColumn(name = "attr_id")}
//    )
//    private Set<Attribute> attributes = new HashSet<>();

    @Column(name = "description", columnDefinition = "")
    @Setter
    private String description = "";

    @Setter
    @Column(name = "parent_id")
    private Element parent;

    @ManyToMany
    @JoinTable(
            name = "element_group",
            joinColumns = { @JoinColumn(name = "element_id") },
            inverseJoinColumns = { @JoinColumn(name = "group_id") }
    )
    private Set<Group> groups = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "elements_composite",
            joinColumns = {@JoinColumn(name = "element_source")},
            inverseJoinColumns = {@JoinColumn(name = "elements_destination")}
    )
    private Set<Element> elements = new HashSet<>();

    @OneToMany
    private Set<ElementFirma> firmaSet = new HashSet<>();


    public Element(String name) {
        this.name = name;
    }

    public Element setParent(Element e) {
        this.parent = e;
        return this;
    }

//    public String getOwnerModel(Equipment equip) {
//        return equip.getModel();
//    }
//
//    public void addOwner(Element elem) {
//        this.setParent(elem.getId());
//    }
//
//    public void addAttribute(Attribute attr) {
//        attributes.add(attr);
////        attr.addComponent(this);
//    }
}
