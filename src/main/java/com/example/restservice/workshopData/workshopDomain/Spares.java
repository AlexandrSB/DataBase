package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Spares {

    @Id
    public Long id;

    private String name;

    @OneToMany(mappedBy = "spares")
    private Set<NumberOfSparesParts> numberOfSparesParts = new HashSet<>();
}
