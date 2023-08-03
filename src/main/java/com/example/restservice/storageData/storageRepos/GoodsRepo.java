package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Goods;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepo extends CrudRepository<Goods, String> {
}
