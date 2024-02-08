package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.AttributeDictionary;
import com.example.restservice.equipmentData.equipmentDomain.AttributeGroupDictionary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttributeDictionaryRepo extends CrudRepository<AttributeDictionary, Long> {
    Optional<AttributeDictionary> findByName(String name);

    @Query(value = """
            SELECT ad
            FROM AttributeDictionary ad
                LEFT JOIN FETCH ad.attributeGroupDictionary agd
            WHERE agd = :owner
            """)
    Iterable<AttributeDictionary> findByOwner(AttributeGroupDictionary owner);
}
