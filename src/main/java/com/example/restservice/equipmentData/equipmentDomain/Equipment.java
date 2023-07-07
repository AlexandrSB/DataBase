package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "model", "type"})
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@EnableAutoConfiguration
@Table(name = "equipment", schema = "public")
public class Equipment {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "equipment_id", nullable = false)
    private Long id;

    @Column(name = "firm_name", nullable = false)
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

    @ManyToMany
    @JoinTable(
            name = "equipment_component",
            joinColumns = { @JoinColumn(name = "equip_id")},
            inverseJoinColumns = {@JoinColumn(name = "comp_id")}
    )
//    @Cascade(CascadeType.ALL)
    private Set<Component> elements = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "group")
    private Groups group;

    public void addElement(Component element) {
        this.elements.add(element);
    }
    public void addElements(List<Component> elements) {
        this.elements.addAll(elements);
    }

}
