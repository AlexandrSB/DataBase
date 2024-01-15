package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Equipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipmentRepo extends CrudRepository<Equipment, Long> {

    @Query(value = """
            SELECT e
            FROM Equipment e
                LEFT JOIN FETCH e.condition
                LEFT JOIN FETCH e.good
            WHERE e.id = ?1
            """)
    Optional<Equipment> findById(Long id);

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

    @Query(value= """
            SELECT e
            FROM Equipment e
                LEFT JOIN FETCH e.condition c
                LEFT JOIN FETCH e.good g
            """)
    Iterable<Equipment> findAllWithLazy();

    @Query(value= """
            SELECT e
            FROM Equipment e
                LEFT JOIN FETCH e.condition c
                LEFT JOIN FETCH e.good g
            WHERE e.inventoryNumber = :inventoryNumber
            """)
    Optional<Equipment> findByInventoryNumber(String inventoryNumber);
}
