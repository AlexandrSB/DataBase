package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor(force = true)
@EqualsAndHashCode(of = {"id", "name"})
@Table(name = "attribute", schema = "public")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "attribute_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "attr_value_id")
//    private AttributeValue attr_value_id;

//
//    @Setter
//    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<AttributeIntegerValue> intValues;


    public Attribute(String n) {
        this.name = n;
    }
}
