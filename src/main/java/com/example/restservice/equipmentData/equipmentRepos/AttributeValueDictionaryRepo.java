package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.AttributeValue;
import com.example.restservice.equipmentData.equipmentDomain.AttributeValueDictionary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeValueDictionaryRepo extends CrudRepository<AttributeValueDictionary, Long> {
}
