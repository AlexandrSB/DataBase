package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@Data
@EqualsAndHashCode(of = {"id", "description"})
@NoArgsConstructor(force = true)
//@RequiredArgsConstructor(onConstructor = @__( @Autowired))
@EnableAutoConfiguration
@Table(name = "equipment", schema = "public")
public class Condition {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column( name = "description" )
    private String name;
}
