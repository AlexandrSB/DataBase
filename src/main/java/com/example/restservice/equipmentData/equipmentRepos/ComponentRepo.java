package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import org.springframework.data.repository.CrudRepository;

public interface ComponentRepo extends CrudRepository<Element, Long> {
    Element findByName(String compName);
}
