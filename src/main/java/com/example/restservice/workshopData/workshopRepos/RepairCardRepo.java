package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.RepairCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairCardRepo extends CrudRepository<RepairCard, Long> {
    @Query(value = """
            SELECT rp
            FROM RepairCard rp
                LEFT JOIN FETCH workshopModules wm
                LEFT JOIN FETCH workshopEquipment we
            WHERE endRepairTimestamp is NULL
            """)
    Iterable<RepairCard> getCardInRepair();
}
