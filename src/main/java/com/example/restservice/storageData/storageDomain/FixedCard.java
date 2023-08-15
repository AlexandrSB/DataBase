package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor(force = true)
@Table(name = "fixed_card", schema = "publc")
public class FixedCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fixed_date")
    private Date fixed_date;

    @ManyToOne
    @JoinColumn(name = "equip_id")
    private Equipment equipment;

    @Column(name = "notice")
    private String notice;
}
