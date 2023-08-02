package com.example.restservice.storageData.storageDomain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(of = {"id", "name", "description"})
@NoArgsConstructor(force = true)
//@RequiredArgsConstructor(onConstructor = @__( @Autowired))
@EnableAutoConfiguration
@Table(name = "equipment", schema = "public")
public class Equipment {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

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
