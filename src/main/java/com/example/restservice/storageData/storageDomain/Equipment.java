package com.example.restservice.storageData.storageDomain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

@Entity
@Data
@NoArgsConstructor(force = true)
@Table(name = "equipment", schema = "public")
public class Equipment {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "inventory_number")
    private String inventoryNumber;

    @ManyToOne
    @JoinColumn(name = "condition_id")
    private Condition condition;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "id")
    private Goods good;
}
