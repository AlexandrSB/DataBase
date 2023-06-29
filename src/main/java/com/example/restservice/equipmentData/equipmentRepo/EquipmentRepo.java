package com.example.restservice.equipmentData.equipmentRepo;

import com.example.restservice.equipmentData.equipmentDomain.Equipment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EquipmentRepo extends CrudRepository<Equipment, Long> {
    List<Equipment> findByModel(String model);
}
