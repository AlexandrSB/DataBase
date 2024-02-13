package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.RepairCardOfEquipment;
import com.example.restservice.workshopData.workshopDomain.RepairCardOfModule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepairCardOfEquipmentRepo
        extends CrudRepository<RepairCardOfEquipment, UUID> {
    @Query(value = """
            SELECT rp
            FROM RepairCardOfEquipment rp
                LEFT JOIN FETCH rp.repairCardOfModules rcom
                LEFT JOIN FETCH rp.workshopElement we
            WHERE endRepairTimestamp is NULL
            """)
    Iterable<RepairCardOfEquipment> getCardInRepair();
}
