package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.AttributeDictionary;
import com.example.restservice.equipmentData.equipmentDomain.AttributeValueDictionary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttributeValueDictionaryRepo extends
        CrudRepository<AttributeValueDictionary, Long> {

    @Query(value = """
            SELECT avd
            FROM AttributeValueDictionary avd
                LEFT JOIN FETCH avd.attributeDictionary atd
            WHERE atd = :owner
            """)
    Iterable<AttributeValueDictionary> findByOwner(AttributeDictionary owner);

    Optional<AttributeValueDictionary> findByName(String name);
}
