package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.WorkshopEquipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopEquipmentRepo extends CrudRepository<WorkshopEquipment, Long> {
    @Query(value = """
            SELECT e.id
            FROM WorkshopEquipment e
            """)
    List<Long> getAllId();
}
