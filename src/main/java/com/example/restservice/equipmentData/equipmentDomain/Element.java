package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Optional;
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

    @NonNull
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "")
    private String description = "";

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Element parent;

//    @ToString.Exclude
//    @OneToMany
//    Set<Unit> units = new HashSet<>();

    @ToString.Exclude
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

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "elements_composite",
            joinColumns = {
                    @JoinColumn(name = "element_source")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "element_destination")
            }
    )
    private Set<Element> elements_source = new HashSet<>();

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST)
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

//    @ManyToMany
//    @JoinTable(
//            name = "element_firma",
//            joinColumns = {
//                    @JoinColumn(name = "element_id")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "firma_id")
//            }
//    )
//    private Set<ElementFirma> firmaSet = new HashSet<>();


    public Element(String name) {
        this.name = name;
    }

    public void addGroup(Optional<Group> group) {
        this.groups.add(group.get());
    }

    public void addElementDesination( Optional<Element> element ) {
        this.elements_destination.add( element.get() );
    }

    public void addElementSource( Optional<Element> element ) {
        this.elements_source.add(element.get());
    }
//    public Element setParent(Element e) {
//        this.parent = e;
//        return this;
//    }
}
