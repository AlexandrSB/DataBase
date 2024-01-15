package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.Model;
import com.sun.jdi.LongValue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepo extends CrudRepository<Model, Long> {

    @Query(value = """
            SELECT m
            FROM Model m
                LEFT JOIN FETCH repairNotationSet
                LEFT JOIN FETCH equipmentSet
            WHERE m.name = :modelName
            """)
    Optional<Model> findByName(String modelName);
}
