package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import java.util.List;

@Entity
@Data
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

//    @Column(name = "firm_name", nullable = false)
//    @NonNull
//    private Firma firmName;

    @Column(name = "model", nullable = false, unique = true)
    @NonNull
    private String model;

    @Column(name = "type")
    @NonNull
    private EnumTypeOfEquipment type;

    @ManyToMany
    @JoinTable(
            name = "equipment_component",
            joinColumns = { @JoinColumn(name = "equip_id")},
            inverseJoinColumns = {@JoinColumn(name = "comp_id")}
    )
//    @Cascade(CascadeType.ALL)
    private Set<Element> elements = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "group")
    private Group group;

    public void addElement(Element element) {
        this.elements.add(element);
    }
    public void addElements(List<Element> elements) {
        this.elements.addAll(elements);
    }

}
