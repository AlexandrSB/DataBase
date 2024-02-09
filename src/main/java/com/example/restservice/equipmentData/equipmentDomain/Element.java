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
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NonNull
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "")
    private String description = "";

    @Column(name = "category", columnDefinition = "")
    private Category category;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Element parent;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn( name = "element_type_id" )
    private ElementType elementType;

    @ToString.Exclude
    @OneToMany(mappedBy = "element_source")
    private Set<ElementsComposite> elementsSource = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "element_destination")
    private Set<ElementsComposite> elementsDestination = new HashSet<>();

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
    @ManyToMany
    @JoinTable(
            name = "element_proxy",
            joinColumns = {
                    @JoinColumn(name = "element_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "proxy_id")
            }
    )
    private Set<Proxy> proxies = new HashSet<>();

    public Element( String name ) {
        this.name = name;
    }

    public void addGroup( Group group ) {
        this.groups.add( group );
    }

    public void addElementDesination( ElementsComposite element ) {
        this.elementsDestination.add( element );
    }

    public void addElementSource( ElementsComposite element ) {
        this.elementsSource.add( element );
    }

//    public Element setParent(Element e) {
//        this.parent = e;
//        return this;
//    }

    public void addProxy(Proxy proxy) {
        this.proxies.add( proxy );
    }
}
