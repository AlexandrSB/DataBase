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
                LEFT JOIN FETCH repairCardOfEquipment rcoe
                LEFT JOIN FETCH workshopModule wm
            WHERE wm.id = :unitId 
            AND rcoe.id = :repairCardUUID
            """)
    Optional<RepairCardOfModule> findByUnitId(UUID repairCardUUID, Long unitId);
}
