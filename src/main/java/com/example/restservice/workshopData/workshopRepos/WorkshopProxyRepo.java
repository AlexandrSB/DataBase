package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.WorkshopProxy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopProxyRepo extends CrudRepository<WorkshopProxy, Long> {
}
