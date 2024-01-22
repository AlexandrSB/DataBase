package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.SparePart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartRepo extends CrudRepository<SparePart, Long> {
}
