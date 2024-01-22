package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "consumption_of_materials")
public class ConsumptionOfMaterials {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //Сюда пишем прокси запчасти
    @Column(name = "type_of_spare_part_id")
    private Long typeOfSparePartId;

    @Column(name = "type_of_spare_part_name")
    private String typeOfSparePartName;

    @Column(name = "quantity_of_material")
    private Integer quantityOfMaterial;

    @Column(name = "status_of_operation")
    private Boolean statusOfOperation;

    @OneToMany(mappedBy = "consumptionOfMaterials")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<WorkshopModule> workshopModules = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "completed_work_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private CompletedWork completedWork;
}
