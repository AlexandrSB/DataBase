package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.Repair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepo extends CrudRepository<Repair, Long> {
}
