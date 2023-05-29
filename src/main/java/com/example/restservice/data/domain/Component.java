package com.example.restservice.data.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Component {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    @Column(name = "component_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Equipment owner;

    @ManyToMany
    @JoinTable(
            name = "component_relationship",
            joinColumns = { @JoinColumn(name="parent_id")},
            inverseJoinColumns = { @JoinColumn(name="child_id")}
    )
    private Set<Component> relationship = new HashSet<>();

    @Column(name = "name", nullable = false)
    private String name;
//    private Boolean isElectronic;
//    private Boolean isMechanic;
//    private Boolean isElectric;

    public Component() {}
    public Component(String name) {
        this.name = name;
    }
    public Component(Equipment equip, String name) {
        owner = equip;
        owner.addElement(this);
        this.name = name;
    }


    public String getOwnerModel() {
        return owner != null ? owner.getModel() : "<none>";
    }

    public Integer getId() {
        return id;
    }

    public Equipment getOwner() {
        return owner;
    }
    public void setOwner(Equipment equip) {
        owner = equip;
        owner.addElement(this);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<Component> getRelationship() {
        return relationship;
    }

    public void setRelationship(Set<Component> relationship) {
        this.relationship = relationship;
    }
}
