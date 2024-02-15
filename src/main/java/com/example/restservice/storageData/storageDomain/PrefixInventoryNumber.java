package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "prefix_inventory_number")
public class PrefixInventoryNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(min = 6, max = 12)
    private String prefix;
}
