package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "module")
public class WorkshopModule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private WorkshopModule parent;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
