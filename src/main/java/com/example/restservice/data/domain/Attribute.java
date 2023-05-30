package com.example.restservice.data.domain;

import jakarta.persistence.*;

import lombok.*;

import java.util.Set;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "attribute_id")
    private Integer id;

    @NonNull
    @Setter
    private String name;

    @NonNull
    @Setter
    private EnumUnits unit;

    @Setter
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AttributeStringValue> strValues;

    @Setter
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AttributeIntegerValue> intValues;
}
