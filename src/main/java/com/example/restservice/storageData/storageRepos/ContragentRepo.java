package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Contragent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContragentRepo extends CrudRepository<Contragent, Long> {
}
