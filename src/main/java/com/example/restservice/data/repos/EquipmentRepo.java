package com.example.restservice.data.repos;

import com.example.restservice.data.domain.Equipment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EquipmentRepo extends CrudRepository<Equipment, Long> {
    List<Equipment> findByModel(String model);
}
