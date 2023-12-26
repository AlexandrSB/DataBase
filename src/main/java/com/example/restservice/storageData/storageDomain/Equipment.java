package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Data
@Table(name = "equipment", schema = "public")
public class Equipment {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 6)
    @Column(
            name = "inventory_number",
            unique = true
    )
    private String inventoryNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "good_id")
    private Good good;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condition_id")
    private Condition condition;

}
