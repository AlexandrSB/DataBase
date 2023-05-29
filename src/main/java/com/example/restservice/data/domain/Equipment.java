package com.example.restservice.data.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

//import java.util.List;

@Entity
@Table(name = "equipment")
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "model", "type"})
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "equipment_id", nullable = false)
    private Integer id;

    @Column(name = "firmName", nullable = false)
    @Enumerated(EnumType.STRING)
    @NonNull
    private EnumFirma firmName;

    @Column(name = "model", nullable = false, unique = true)
    @NonNull
    private String model;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @NonNull
    private EnumTypeOfEquipment type;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "equipment_components")
//    @Cascade(CascadeType.ALL)
    private List<Component> elements;


    public void addElement(Component element) {
        this.elements.add(element);
    }
    public void addElements(List<Component> elements) {
        this.elements.addAll(elements);
    }

}
