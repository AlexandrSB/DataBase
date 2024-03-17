package com.example.restservice.storageData.storageRepos;

import com.example.restservice.equipmentData.equipmentDomain.Category;
import com.example.restservice.storageData.storageDomain.Good;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoodsRepo extends CrudRepository<Good, Long> {
    Optional<Good> findByName(String goodName);

    @Query(value = """
            SELECT g.name
            FROM Good g
            """)
    Iterable<String> getGoodsNames();

    @Query(value= """
            SELECT g
            FROM Good g
                LEFT JOIN FETCH g.equipment e
                LEFT JOIN FETCH g.parcels p
            """)
    Iterable<Good> findAllWithLazy();

    @Query(value = """
            SELECT g.name
            FROM Good g
            WHERE g.category = :category
            ORDER BY g.name
            """)
    Iterable<String> findAllOnlyNameByCategory(Category category);

    @Query(value = """
            SELECT g
            FROM Good g
            WHERE g.category > 0
            ORDER BY g.category, g.name
            """)
    Iterable<Good> findAllNotEquipment();
}
