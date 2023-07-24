package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


@Entity
@Data
@EqualsAndHashCode(of = {"id", "firm_name"})
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@EnableAutoConfiguration
@Table(name = "firma", schema = "public")
public class Firma {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "firma_id", nullable = false)
    private Long id;

    @Column(name = "firm_name")
    private String firm_name;
}
