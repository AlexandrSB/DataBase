package com.example.restservice.equipmentData.equipmentRepo;

import com.example.restservice.equipmentData.equipmentDomain.Component;
import org.springframework.data.repository.CrudRepository;

public interface ComponentRepo extends CrudRepository<Component, Long> {
    Component findByName(String compName);
}
