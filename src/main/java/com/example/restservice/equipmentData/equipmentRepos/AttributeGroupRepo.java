package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.AttributeGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttributeGroupRepo extends CrudRepository<AttributeGroup, Long> {

    Iterable<AttributeGroup> findAllByName(String attributeCroupName);

    Optional<AttributeGroup> findByName(String attributeCroupName);
}
