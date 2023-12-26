package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Equipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepo extends CrudRepository<Equipment, Long> {

    @Query(value = """
                SELECT e
                FROM Equipment e
                LEFT JOIN FETCH e.condition
                LEFT JOIN FETCH e.good
                WHERE e.condition.id = 2
            """)
    List<Equipment> getEquipmentByAwaitingRepairs();
}
