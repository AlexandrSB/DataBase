package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.AttributeIntegerValue;
import org.springframework.data.repository.CrudRepository;

public interface AttributeIntegerValueRepo extends CrudRepository<AttributeIntegerValue, Long> {
}