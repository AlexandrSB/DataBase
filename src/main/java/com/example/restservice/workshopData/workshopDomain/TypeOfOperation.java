package com.example.restservice.workshopData.workshopDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "type_of_operation")
public class TypeOfOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "operation_type")
    private OperationType operationType;

    @ManyToOne
    @JoinColumn(name = "completed_work_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private CompletedWork completedWork;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private WorkshopUnit workshopUnit;
}
