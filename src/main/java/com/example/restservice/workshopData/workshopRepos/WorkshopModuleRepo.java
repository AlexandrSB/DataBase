package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.WorkshopModule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkshopModuleRepo extends CrudRepository<WorkshopModule, Long> {

    @Query(value = """
            SELECT wm
            FROM WorkshopModule wm
                LEFT JOIN FETCH workshopUnit wu
                LEFT JOIN FETCH workshopElement we
                LEFT JOIN FETCH consumptionOfMaterials com
                LEFT JOIN FETCH repairCardOfModules rcom
            WHERE we.id = :workshopElementId
            AND wu.id = :workshopUnitId
            """)
    Optional<WorkshopModule> findModule(Long workshopElementId, Long workshopUnitId);
}
