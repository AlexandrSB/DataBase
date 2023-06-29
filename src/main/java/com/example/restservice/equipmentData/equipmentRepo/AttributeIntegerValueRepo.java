package com.example.restservice.equipmentData.equipmentRepo;

import com.example.restservice.equipmentData.equipmentDomain.AttributeIntegerValue;
import org.springframework.data.repository.CrudRepository;

public interface AttributeIntegerValueRepo extends CrudRepository<AttributeIntegerValue, Long> {
}