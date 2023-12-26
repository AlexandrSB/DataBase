package com.example.restservice.workshopData.workshopRepos;

import com.example.restservice.workshopData.workshopDomain.Equipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopEquipmentRepo extends CrudRepository<Equipment, Long> {
    @Query(value = """
            SELECT e.id
            FROM Equipment e
            """)
    List<Long> getAllId();
}
