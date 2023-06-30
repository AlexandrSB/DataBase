package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Table(name = "attribute_string_value", schema = "public")
public class AttributeStringValue {
    @Id
    @Column(name = "attr_str_val")
    private Integer id;

    @Setter
    @NonNull
    private String value;
}
