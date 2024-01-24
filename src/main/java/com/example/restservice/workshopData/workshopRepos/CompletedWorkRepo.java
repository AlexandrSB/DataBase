package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.CompletedWork;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedWorkRepo extends CrudRepository<CompletedWork, Long> {

    @Query(value = """
            SELECT cw
            FROM CompletedWork cw
                LEFT JOIN FETCH consumptionOfMaterials com
                LEFT JOIN FETCH typeOfOperations too
            """)
    Iterable<CompletedWork> findAll();

    @Query(value = """
            SELECT cw
            FROM CompletedWork cw
                LEFT JOIN FETCH consumptionOfMaterials com
                LEFT JOIN FETCH typeOfOperations too
            WHERE too.workshopUnit.id = :workshopUnitId
            """)
    Iterable<CompletedWork> findAllByUnitId(Long workshopUnitId);
}
