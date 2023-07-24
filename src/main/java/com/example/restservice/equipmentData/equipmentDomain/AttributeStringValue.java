package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Table(name = "attribute_string_value", schema = "public")
public class AttributeStringValue {
    @Id
    @Column(name = "attr_str_val")
    @ManyToOne
    @JoinColumn(name = "attr_value_id", nullable = false, unique = true)
    private AttributeValue id;

    @Setter
    @NonNull
    private String value;
}
