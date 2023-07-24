package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.Unit;
import org.springframework.data.repository.CrudRepository;

public interface UnitRepo extends CrudRepository<Unit, Long> {
}
