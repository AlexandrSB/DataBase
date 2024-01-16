package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.WorkshopModule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepo extends CrudRepository<WorkshopModule, Long> {
}
