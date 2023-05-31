package com.example.restservice.data.repos;

import com.example.restservice.data.domain.Component;
import org.springframework.data.repository.CrudRepository;

public interface ComponentRepo extends CrudRepository<Component, Long> {
    Component findByName(String compName);
}
