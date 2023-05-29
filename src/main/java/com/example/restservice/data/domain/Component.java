package com.example.restservice.data.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "name"})
@NoArgsConstructor(force = true)
public class Component {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    @Column(name = "component_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    @NonNull
    private Equipment owner;

    @ManyToMany
    @JoinTable(
            name = "component_relationship",
            joinColumns = { @JoinColumn(name="parent_id")},
            inverseJoinColumns = { @JoinColumn(name="child_id")}
    )
    private Set<Component> relationship = new HashSet<>();

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @Column(name = "description")
    private String description;


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

    public void setOwner(Equipment equip) {
        owner = equip;
        owner.addElement(this);
    }
}
