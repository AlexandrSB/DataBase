package com.example.restservice.repos;

import com.example.restservice.domain.Equipment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EquipmentRepo extends CrudRepository<Equipment, Long> {
    List<Equipment> findByModel(String model);
}
