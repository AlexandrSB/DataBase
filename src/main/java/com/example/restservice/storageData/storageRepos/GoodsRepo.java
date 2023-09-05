package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Good;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoodsRepo extends CrudRepository<Good, Long> {
    Optional<Good> findByName(String goodName);
}
