package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor(force = true)
@Table(name = "elements_composite", schema = "public")
public class ElementsComposite {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "element_source")
    private Element element_source;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "element_destination")
    private Element element_destination;
}
