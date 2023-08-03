package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.CompletedWork;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedWorkRepo extends CrudRepository<CompletedWork, Long> {
}
