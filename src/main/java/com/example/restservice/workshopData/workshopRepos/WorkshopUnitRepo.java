package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.WorkshopUnit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkshopUnitRepo extends CrudRepository<WorkshopUnit, Long> {

    @Query(value = """
            SELECT wu
            FROM WorkshopUnit wu
                LEFT JOIN FETCH typeOfOperations
                LEFT JOIN FETCH spareParts
                LEFT JOIN FETCH workshopModules
            WHERE wu.name = :workshopUnitName
            """)
    Optional<WorkshopUnit> findByName(String workshopUnitName);
}
