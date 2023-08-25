package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElementRepo extends CrudRepository<Element, Long> {
    @Override
    Optional<Element> findById(Long aLong);

    Optional<Element> findByName(String compName);
}
