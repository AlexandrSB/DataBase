package com.example.restservice.storageData.storageRepo;

import com.example.restservice.storageData.storageDomain.Storage;
import org.springframework.data.repository.CrudRepository;


public interface StorageRepo extends CrudRepository<Storage, Long> {
}
