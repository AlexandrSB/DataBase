package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.AttributeGroupDictionary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttributeGroupDictionaryRepo extends CrudRepository<AttributeGroupDictionary, Long> {
    Optional<AttributeGroupDictionary> findByName(String name);
}
