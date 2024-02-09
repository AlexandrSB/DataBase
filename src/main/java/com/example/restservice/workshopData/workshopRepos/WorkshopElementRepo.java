package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.WorkshopElement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkshopElementRepo extends CrudRepository<WorkshopElement, Long> {
    @Query(value = """
            SELECT e.id
            FROM WorkshopEquipment e
            """)
    List<Long> getAllId();

    @Query(value = """
            SELECT we
            FROM WorkshopEquipment we
            WHERE we.inventoryNumber = :inventoryNumber
            """)
    Optional<WorkshopElement> findByInventoryNumber(String inventoryNumber);
}
