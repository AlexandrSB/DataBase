package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Equip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipRepo extends CrudRepository<Equip, Long> {
}
