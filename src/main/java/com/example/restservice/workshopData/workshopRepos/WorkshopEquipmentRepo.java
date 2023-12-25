package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.Equipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopEquipmentRepo extends CrudRepository<Equipment, Long> {
}
