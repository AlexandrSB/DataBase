package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Condition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepo extends CrudRepository<Condition, Long> {
}
