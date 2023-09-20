package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Parcel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepo extends CrudRepository<Parcel, Long> {
}
