package com.example.restservice.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class AttributeStringValue {
    @Id
    @Column(name = "attr_str_val")
    private Integer id;

    @Setter
    @NonNull
    private String value;
}
