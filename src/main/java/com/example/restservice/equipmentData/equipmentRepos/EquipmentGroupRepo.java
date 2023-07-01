package com.example.restservice.equipmentData.equipmentRepos;


import com.example.restservice.equipmentData.equipmentDomain.EquipmentGroup;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentGroupRepo extends CrudRepository<EquipmentGroup, Long> {
}
