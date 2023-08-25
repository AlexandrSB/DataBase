package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.ElementsComposite;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ElementsCompositeRepo
        extends CrudRepository<ElementsComposite, Long> {

    Optional<ElementsComposite> findById(Long id);
}
