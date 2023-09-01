package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "equipment", schema = "public")
public class Equipment {

    @Id
    private Long id;

    @Size(min = 6)
    @Column(name = "inventory_number")
    private String inventoryNumber;

    @OneToOne(mappedBy = "equipment")
    private Good good;
}
