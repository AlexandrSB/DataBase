package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.QuantityAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityAccountRepo extends CrudRepository<QuantityAccount, Long> {
}
