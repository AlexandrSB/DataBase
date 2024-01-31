package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.ConsumptionOfMaterial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ConsumptionOfMaterialRepo extends CrudRepository<ConsumptionOfMaterial, Long> {

    @Query(value = """
            SELECT com, cw
            FROM ConsumptionOfMaterial com
               LEFT JOIN FETCH com.workshopModule AS wm
               LEFT JOIN FETCH com.completedWork AS cw
               LEFT JOIN FETCH com.repairCardOfModule AS rcom
            WHERE wm.id = :moduleId
            """)
    Iterable<ConsumptionOfMaterial> findAllWithLazy(UUID moduleId);
}
