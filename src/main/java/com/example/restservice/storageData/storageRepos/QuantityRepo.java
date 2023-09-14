package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Quantity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuantityRepo extends CrudRepository<Quantity, Long> {
    Optional<Quantity> findByDimension(String quantityDimension);
}
