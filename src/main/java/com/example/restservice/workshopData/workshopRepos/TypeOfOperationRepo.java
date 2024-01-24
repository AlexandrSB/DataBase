package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.OperationType;
import com.example.restservice.workshopData.workshopDomain.TypeOfOperation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeOfOperationRepo extends CrudRepository<TypeOfOperation, Long> {

    @Query(value = """
            SELECT too
            FROM TypeOfOperation too
            WHERE too.operationType = :operationType
            """)
    Optional<TypeOfOperation> findByOperationType(OperationType operationType);
}
