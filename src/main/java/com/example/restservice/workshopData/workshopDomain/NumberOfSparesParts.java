package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class NumberOfSparesParts {

    @Id
    private Long id;

    private Integer counter;

    @ManyToOne
    @JoinColumn(name = "spares_id")
    private Spares spares;

    @ManyToOne
    @JoinColumn(name = "repairs_id")
    private Repair repair;
}
