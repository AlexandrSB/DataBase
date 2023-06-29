package com.example.restservice.equipmentData.equipmentRepo;

import com.example.restservice.equipmentData.equipmentDomain.Attribute;
import org.springframework.data.repository.CrudRepository;

public interface AttributeRepo extends CrudRepository<Attribute, Long> {
    Attribute findByName(String name);
}
