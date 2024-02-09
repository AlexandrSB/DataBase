package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.SparePart;
import com.example.restservice.workshopData.workshopDomain.TypeOfSparePart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SparePartRepo extends CrudRepository<SparePart, Long> {
    Optional<SparePart> findByName(String name);
}
