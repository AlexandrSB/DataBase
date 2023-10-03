package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Storage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StorageRepo extends CrudRepository<Storage, Long> {
    Optional<Storage> findByName(String storageName);
}
