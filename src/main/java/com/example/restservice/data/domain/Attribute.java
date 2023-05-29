package com.example.restservice.data.domain;

import jakarta.persistence.*;

import lombok.*;

import java.util.Map;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "attribute_id")
    private Integer id;
    @NonNull
    private String name;
    private String strValues;
    private Integer intValues;
}
