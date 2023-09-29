package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.GoodsTrackingFromContragent;
import org.springframework.data.repository.CrudRepository;

public interface GoodsTrackingFromContragentRepo extends CrudRepository<
        GoodsTrackingFromContragent, Long> {
}
