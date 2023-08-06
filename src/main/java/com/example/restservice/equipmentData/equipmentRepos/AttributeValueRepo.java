package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.AttributeValue;
import org.springframework.data.repository.CrudRepository;

public interface AttributeValueRepo extends CrudRepository<AttributeValue, Long> {
}
