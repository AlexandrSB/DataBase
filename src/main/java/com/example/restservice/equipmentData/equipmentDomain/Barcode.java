package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@Data
@EqualsAndHashCode(of = {"id", "barcode"})
@NoArgsConstructor(force = true)
@EnableAutoConfiguration
@Table(name = "barcode", schema = "public")
public class Barcode {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "barcode_id", nullable = false, unique = true)
    private Element element;

    @Column(name = "barcode")
    private String barcode;
}
