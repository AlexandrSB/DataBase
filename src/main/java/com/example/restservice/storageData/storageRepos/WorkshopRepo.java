package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Workshop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopRepo extends CrudRepository<Workshop, Long> {
}
