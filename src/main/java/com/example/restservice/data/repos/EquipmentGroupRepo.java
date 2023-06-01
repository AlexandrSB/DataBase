package com.example.restservice.data.repos;


import com.example.restservice.data.domain.EquipmentGroup;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentGroupRepo extends CrudRepository<EquipmentGroup, Long> {
}
