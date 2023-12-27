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
                WHERE e.condition.id = ?1
            """)
    List<Equipment> getEquipmentByCondition(Long condition_id);

    @Query(value = """
            SELECT e
            FROM Equipment e
                LEFT JOIN FETCH e.condition
                LEFT JOIN FETCH e.good
                WHERE e.good.id = ?1
            """)
    List<Equipment> getEquipmentByGood(Long good_id);
}
