package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@EqualsAndHashCode(of = {"id", "value"})
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class AttributeIntegerValue {
    @Id
    @Column(name = "attr_int_id")
    private Integer id;

    @Setter
    @NonNull
    private Integer value;
}
