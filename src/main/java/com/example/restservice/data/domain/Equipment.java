package com.example.restservice.data.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

//import java.util.List;

@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "equipment_id", nullable = false)
    private Integer id;
    @Column(name = "firmName", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumFirma firmName;
    @Column(name = "model", nullable = false, unique = true)
    private String model;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EnumTypeOfEquipment type;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "equipment_components")
//    @Cascade(CascadeType.ALL)
    private List<Component> elements;

    public Equipment() {
    }
    public Equipment(EnumFirma firmName, String model, EnumTypeOfEquipment type) {
        this.firmName = firmName;
        this.model = model;
        this.type = type;
    }

    public void addElement(Component element) {
        this.elements.add(element);
    }
    public void addElements(List<Component> elements) {
        this.elements.addAll(elements);
    }
    public Integer getId() {
        return id;
    }

    public EnumFirma getFirmName() {
        return firmName;
    }

    public void setFirmName(EnumFirma firmName) {
        this.firmName = firmName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public EnumTypeOfEquipment getType() {
        return type;
    }

    public void setType(EnumTypeOfEquipment type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(id, equipment.id) && Objects.equals(firmName, equipment.firmName) && Objects.equals(model, equipment.model) && Objects.equals(type, equipment.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firmName, model, type);
    }
}
