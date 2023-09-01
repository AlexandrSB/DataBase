package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.ElementType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElementTypeRepo extends CrudRepository<ElementType, Long> {
    Optional<ElementType> findByType(String elementType);
}
