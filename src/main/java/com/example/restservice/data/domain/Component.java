package com.example.restservice.data.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@EqualsAndHashCode(of = {"id", "name"})
@NoArgsConstructor(force = true)
public class Component {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    @Column(name = "component_id")
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "equipment_component",
            joinColumns = { @JoinColumn(name = "comp_id")},
            inverseJoinColumns = { @JoinColumn(name = "equip_id")}
    )
    private Set<Equipment> owner = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "component_relationship",
            joinColumns = { @JoinColumn(name="parent_id")},
            inverseJoinColumns = { @JoinColumn(name="child_id")}
    )
    private Set<Component> relationship = new HashSet<>();

    @Column(name = "name", nullable = false)
    @NonNull
    @Setter
    private String name;

    @ManyToMany
    @JoinTable(
            name = "component_attribute",
            joinColumns = {@JoinColumn(name = "comp_id")},
            inverseJoinColumns = { @JoinColumn(name = "attr_id")}
    )
    private Set<Attribute> attributes = new HashSet<>();

    @Column(name = "description", columnDefinition = "")
    @Setter
    private String description;

    @Column(name = "isComposit")
    @Setter
    private Boolean isComposite;

    @Column(name = "isMechanic")
    @Setter
    private Boolean isMechanic;

    @Column(name = "isElectronic")
    @Setter
    private Boolean isElectronic;

    @Column(name = "isElectric")
    @Setter
    private Boolean isElectric;

    public Component(String name) {
        this.name = name;
    }


    public String getOwnerModel(Equipment equip) {
        return equip.getModel();
    }

    public void addOwner(Equipment equip) {
        owner.add(equip);
//        equip.addElement(this);
    }

    public void addAttribute(Attribute attr) {
        attributes.add(attr);
//        attr.addComponent(this);
    }
}
