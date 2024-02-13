package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.PrefixInventoryNumber;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PrefixInventoryNumberRepo extends CrudRepository<PrefixInventoryNumber, Long> {
    Optional<PrefixInventoryNumber> findByPrefix(String prefix);
}