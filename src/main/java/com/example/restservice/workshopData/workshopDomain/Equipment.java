package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Equipment {

    @Id
    private Long id;

    private String name;

    @Column(name = "inventory_number")
    private String inventoryNumber;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
