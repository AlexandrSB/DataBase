package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Storage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepo extends CrudRepository<Storage, Long> {
}
