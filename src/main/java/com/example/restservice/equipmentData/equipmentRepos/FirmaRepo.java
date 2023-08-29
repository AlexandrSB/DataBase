package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.Firma;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmaRepo extends CrudRepository<Firma, Long> {
    Firma findByFirmName(String firma);
}
