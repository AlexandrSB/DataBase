package com.example.restservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Component_relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

//    private Component fromComponent;
//    private Component toComponent;


    public Component_relationship() {
    }
}
