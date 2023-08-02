package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@EqualsAndHashCode(of = {"id", "firm_name"})
@NoArgsConstructor(force = true)
@EnableAutoConfiguration
@Table(name = "firma", schema = "public")
public class Firma {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "firma_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "firm_name", nullable = false, unique = true)
    private String firm_name;

    @OneToMany
    private Set<ElementFirma> elementSet = new HashSet<>();
}
