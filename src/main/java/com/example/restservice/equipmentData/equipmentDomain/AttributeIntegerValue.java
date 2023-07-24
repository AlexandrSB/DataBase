package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(of = {"id", "value"})
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Table(name = "attribute_integer_name", schema = "public")
public class AttributeIntegerValue {

    @Id
    @Column(name = "attr_int_id")
    @ManyToOne
    @JoinColumn(name = "attr_value_id", nullable = false)
    private AttributeValue id;

    @Setter
    @NonNull
    private Integer value;
}
