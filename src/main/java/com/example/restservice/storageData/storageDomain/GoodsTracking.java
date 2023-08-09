package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@EqualsAndHashCode(of = {"id", "quantity"})
@NoArgsConstructor(force = true)
@Table(name = "goods_tracking", schema = "public")
public class GoodsTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "direction", nullable = false)
    private Direction direction;

    @ManyToOne
    @JoinColumn(name = "storage")
    private Storage storage;

    @ManyToOne
    @JoinColumn(name = "contragent")
    private Contragent contragent;
}
