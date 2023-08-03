package com.example.restservice.storageData.storageDomain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.lang.NonNull;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor(force = true)
@Table(name = "equipment", schema = "public")
public class Equip {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Column( name = "name" )
    private String name;

    @Column( name = "description" )
    private String description;

    @Column( name = "inventory_number" )
    private Long inventory_number;

    @ManyToOne
    @JoinColumn( name = "condition_id" )
    private Condition condition;

    @ManyToOne
    @JoinColumn( name = "completed_work_id" )
    private CompletedWork completedWork;
}
