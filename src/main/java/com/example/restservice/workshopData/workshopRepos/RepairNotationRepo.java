package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.RepairNotation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairNotationRepo extends CrudRepository<RepairNotation, Long> {

    @Query(value = """
            SELECT rn
            FROM RepairNotation rn
                LEFT JOIN FETCH models m
                LEFT JOIN FETCH repairSet
            """)
    Iterable<RepairNotation> findAll();

    @Query(value = """
            SELECT rn
            FROM RepairNotation rn
                LEFT JOIN FETCH models m
                LEFT JOIN FETCH repairSet
            WHERE m.name in :model_name
            """)
    Iterable<RepairNotation> findAllByModel(String model_name);
}
