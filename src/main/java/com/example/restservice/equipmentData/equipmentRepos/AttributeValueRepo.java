package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.Attribute;
import com.example.restservice.equipmentData.equipmentDomain.AttributeValue;
import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentDomain.Unit;
import org.springframework.data.repository.CrudRepository;

public interface AttributeValueRepo extends CrudRepository<AttributeValue, Long> {
}
