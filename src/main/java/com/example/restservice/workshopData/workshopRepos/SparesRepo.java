package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.Spares;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparesRepo extends CrudRepository<Spares, Long> {
}
