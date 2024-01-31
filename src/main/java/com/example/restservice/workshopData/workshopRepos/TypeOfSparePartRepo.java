package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.TypeOfSparePart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeOfSparePartRepo extends CrudRepository<TypeOfSparePart, Long> {

    @Query(value = """
            SELECT tosp
            FROM TypeOfSparePart AS tosp
            WHERE tosp.name = :name
            """)
    Optional<TypeOfSparePart> findByName(String name);
}
