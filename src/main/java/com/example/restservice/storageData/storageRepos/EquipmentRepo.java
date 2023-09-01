package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Equipment;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentRepo extends CrudRepository<Equipment, Long> {
}
