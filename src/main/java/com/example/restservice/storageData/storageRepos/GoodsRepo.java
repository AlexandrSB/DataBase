package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Good;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface GoodsRepo extends CrudRepository<Good, Long> {
    Optional<Good> findByName(String goodName);

    @Query(value = """
            SELECT g.name
            FROM Good g
            """)
    List<String> getGoodsNames();

    @Query(value= """
            SELECT g
            FROM Good g
                LEFT JOIN FETCH equipment e
                LEFT JOIN FETCH parcels p
            """)
    Set<Good> findAllWithLazy();
}
