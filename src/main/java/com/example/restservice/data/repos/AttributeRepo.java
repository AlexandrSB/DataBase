package com.example.restservice.data.repos;

import com.example.restservice.data.domain.Attribute;
import org.springframework.data.repository.CrudRepository;

public interface AttributeRepo extends CrudRepository<Attribute, Long> {
    Attribute findByName(String name);
}
