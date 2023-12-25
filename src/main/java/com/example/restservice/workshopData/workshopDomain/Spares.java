package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Spares {

    @Id
    public Long id;


}
