package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(of = {"id", "unit_name"})
@NoArgsConstructor(force = true)
@EnableAutoConfiguration
@Table(name = "unit", schema = "public")
public class Unit {

    @Id
//    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    @ToString.Exclude
    private AttributeValue attributeValue;

    @ManyToOne
    @JoinColumn(name = "unit_dic_id")
    @ToString.Exclude
    private UnitDictionary unitDictionary;

}
