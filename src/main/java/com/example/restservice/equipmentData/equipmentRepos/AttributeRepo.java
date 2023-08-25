package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.Attribute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttributeRepo extends CrudRepository<Attribute, Long> {
    Optional<Attribute> findByName(String name);
}
