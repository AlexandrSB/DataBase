package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.ElementType;
import com.example.restservice.equipmentData.equipmentDomain.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElementTypeRepo extends CrudRepository<ElementType, Long> {
    Optional<ElementType> findByType(String elementType);

    @Query(value = """
            SELECT et
            FROM ElementType et
            WHERE et.group = :group 
            """)
    Iterable<ElementType> findByGroup(Group group);
}
