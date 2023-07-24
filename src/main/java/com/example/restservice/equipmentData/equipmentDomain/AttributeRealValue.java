package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Table(name = "attribute_real_value", schema = "public")
public class AttributeRealValue {
    @Id
    @Column(name = "attr_real_val")
    @ManyToOne
    @JoinColumn(name = "attr_value_id", nullable = false)
    private AttributeValue id;

    @Setter
    @NonNull
    private Double value;
}