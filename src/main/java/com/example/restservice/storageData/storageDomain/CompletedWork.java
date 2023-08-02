package com.example.restservice.storageData.storageDomain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(of = {"id", "name"})
@NoArgsConstructor(force = true)
//@RequiredArgsConstructor(onConstructor = @__( @Autowired ))
@EnableAutoConfiguration
@Table(name = "completed_work", schema = "public")
public class CompletedWork {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column( name = "descriptipn" )
    private String description;

    @Column( name = "date" )
    private Date date;
}
