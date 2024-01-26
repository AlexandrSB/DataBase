package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.ConsumptionOfMaterial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionOfMaterialRepo extends CrudRepository<ConsumptionOfMaterial, Long> {

}
