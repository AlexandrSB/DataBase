package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(of = {"id", "name", "description"})
@NoArgsConstructor(force = true)
@Table(name = "element", schema = "public")
public class Element {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    @Column(name = "element_id", nullable = false, unique = true)
    private Long id;

    @Setter
//    @NonNull
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Setter
    @Column(name = "description", columnDefinition = "")
    private String description = "";

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Element parent;

    @ManyToMany
    @JoinTable(
            name = "element_groups",
            joinColumns = {
                    @JoinColumn(name = "element_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "group_id")
            }
    )
    private Set<Group> groups = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "elements_composite",
            joinColumns = {
                    @JoinColumn(name = "element_source")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "elements_destination")
            }
    )
    private Set<Element> elements_source = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "elements_composite",
            joinColumns = {
                    @JoinColumn(name = "element_destination")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "element_source")
            }
    )
    private Set<Element> elements_destination = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "element_firma",
            joinColumns = {
                    @JoinColumn(name = "element_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "firma_id")
            }
    )
    private Set<ElementFirma> firmaSet = new HashSet<>();

    public Element(String name) {
        this.name = name;
    }

//    public Element setParent(Element e) {
//        this.parent = e;
//        return this;
//    }
}
