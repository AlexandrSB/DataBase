package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@Table(name = "equipment")
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "model", "type"})
@NoArgsConstructor(force = true)
//@RequiredArgsConstructor
@EnableAutoConfiguration
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "equipment_id", nullable = false)
    private Long id;

    @Column(name = "storage_name")
    private String storageName;
}
