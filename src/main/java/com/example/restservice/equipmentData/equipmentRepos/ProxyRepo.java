package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.Proxy;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProxyRepo extends CrudRepository<Proxy, Long> {
    Optional<Proxy> findByName(String proxyDestination);
}
