package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor(force = true)
@EnableAutoConfiguration
@Table(name = "element_firma", schema = "public")
public class ElementFirma {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "equipment_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "element_id")
    private Element element;

    @ManyToOne
    @JoinColumn(name = "firma_id")
    private Firma firma;
}
