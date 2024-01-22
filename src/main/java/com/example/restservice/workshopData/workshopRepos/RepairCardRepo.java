package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.RepairCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairCardRepo extends CrudRepository<RepairCard, Long> {

    @Query(value = """
            SELECT rc
            FROM RepairCard rc
                LEFT JOIN FETCH workshopModules wm
            """)
    Iterable<RepairCard> findAll();

    @Query(value = """
            SELECT rc
            FROM RepairCard rc
                LEFT JOIN FETCH workshopModules wm
            WHERE wm.name in :module_name
            """)
    Iterable<RepairCard> findAllByModelName(String module_name);
}
