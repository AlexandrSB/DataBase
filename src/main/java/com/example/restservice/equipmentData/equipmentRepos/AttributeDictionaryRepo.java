package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.AttributeDictionary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttributeDictionaryRepo extends CrudRepository<AttributeDictionary, Long> {
    Optional<AttributeDictionary> findByName(String name);
}
