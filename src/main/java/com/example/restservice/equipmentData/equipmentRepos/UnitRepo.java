package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitRepo extends CrudRepository<Unit, Long> {
    Optional<Unit> findByName(String unitName);
}
