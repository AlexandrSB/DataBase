package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(of = {"id", "value"})
@NoArgsConstructor(force = true)
@Table(name = "attribute_integer_name", schema = "public")
public class AttributeIntegerValue {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "attr_value_id", nullable = false, unique = true)
    private Long id;

    @Setter
    @NonNull
    private Integer value;

    @NonNull
    @OneToOne
    @MapsId
    @ToString.Exclude
    private AttributeValue attributeValue;

}
