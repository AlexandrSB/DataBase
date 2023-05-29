package com.example.restservice.domain;

import jakarta.persistence.*;

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

//    @ManyToOne
//    @JoinColumn(name = "unit_id", nullable = false)
//    private Component unit;

//    @OneToMany
//    private Set<Component> units;

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

//    public Component getUnit() {
//        return unit;
//    }
//
//    public void setUnit(Component component) {
//        if (this != component) {
//            unit = component;
//        }
////        this.units
//    }

//    public Set<Component> getUnits() {
//        return units;
//    }
//
//    public void addUnits(Component component) {
//        if (this != component) {
//            this.units.add(component);
//        }
//    }

//    public void addAllUnits(List<Component> componentList) {
//        this.units.addAll(componentList);
//    }
//    public Boolean getElectronic() {
//        return isElectronic;
//    }
//    public void setElectronic(Boolean electronic) {
//        isElectronic = electronic;
//    }
//
//    public Boolean getMechanic() {
//        return isMechanic;
//    }
//    public void setMechanic(Boolean mechanic) {
//        isMechanic = mechanic;
//    }
//
//    public Boolean getElectric() {
//        return isElectric;
//    }
//    public void setElectric(Boolean electric) {
//        isElectric = electric;
//    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
