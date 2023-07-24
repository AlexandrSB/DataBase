package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.Barcode;
import org.springframework.data.repository.CrudRepository;

public interface BarcodeRepo extends CrudRepository<Barcode, Long> {
}
