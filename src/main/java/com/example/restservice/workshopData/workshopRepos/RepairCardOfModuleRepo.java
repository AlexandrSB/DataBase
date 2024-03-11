package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.RepairCardOfModule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepairCardOfModuleRepo extends CrudRepository<RepairCardOfModule, UUID> {

    @Query(value = """
            SELECT rcom
            FROM RepairCardOfModule rcom
                LEFT JOIN FETCH rcom.repairCardOfEquipment rcoe
                LEFT JOIN FETCH rcom.workshopModule wm
            WHERE wm.id = :moduleId 
            AND rcoe.id = :repairCardUUID
            """)
    Optional<RepairCardOfModule> findByUnitId(UUID repairCardUUID, UUID moduleId);


    @Query(value = """
            SELECT rcom
            FROM RepairCardOfModule rcom
                LEFT JOIN FETCH rcom.repairCardOfEquipment rcoe
                LEFT JOIN FETCH rcom.workshopModule wm
                LEFT JOIN FETCH rcom.consumptionOfMaterials com
            WHERE rcoe.id = :repairCardUUID 
            """)
    Iterable<RepairCardOfModule> findByRepairCardId(UUID repairCardUUID);
}
