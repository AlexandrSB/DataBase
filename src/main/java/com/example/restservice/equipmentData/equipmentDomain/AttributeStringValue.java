package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@Table(name = "attribute_string_value", schema = "public")
public class AttributeStringValue {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "attr_value_id", nullable = false, unique = true)
    private Long id;

    @NonNull
    @OneToOne
    private AttributeValue attributeValue;

    @Setter
    @NonNull
    private String value;
}
