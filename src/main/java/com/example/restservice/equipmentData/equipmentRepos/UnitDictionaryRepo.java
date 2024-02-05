package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.UnitDictionary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitDictionaryRepo extends CrudRepository<UnitDictionary, Long> {
    Optional<UnitDictionary> findByName(String unitName);
}
