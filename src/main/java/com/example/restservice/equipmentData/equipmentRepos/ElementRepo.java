package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import org.springframework.data.repository.CrudRepository;

public interface ElementRepo extends CrudRepository<Element, Long> {
    Element findByName(String compName);
}
