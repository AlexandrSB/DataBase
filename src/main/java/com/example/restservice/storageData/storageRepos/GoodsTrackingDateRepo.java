package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.GoodsTrackingDate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsTrackingDateRepo extends CrudRepository<GoodsTrackingDate, Long> {
}
