package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Equipment {

    @Id
    @GeneratedValue
    private Long id;

    private String inventoryNumber;

    @OneToOne(mappedBy = "equipment")
    private Good good;
}
