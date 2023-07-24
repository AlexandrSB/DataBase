package com.example.restservice.equipmentData.equipmentDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@Data
@EqualsAndHashCode(of = {"id", "model", "type"})
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@EnableAutoConfiguration
@Table(name = "barcode", schema = "public")
public class Barcode {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @ManyToOne
    @JoinColumn(name = "barcode_id", nullable = false)
    private Long id;

    @Column(name = "barcode")
    private String barcode;
}
