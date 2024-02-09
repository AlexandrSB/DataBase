package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentDomain.ElementsComposite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ElementsCompositeRepo
        extends CrudRepository<ElementsComposite, Long> {

    Optional<ElementsComposite> findById(Long id);

    @Query(value = """
            SELECT es
            FROM ElementsComposite ec
                LEFT JOIN FETCH Element ed
                    ON ed = ec.element_destination
                LEFT JOIN FETCH Element es
                    ON es = ec.element_source
            WHERE ed = :element
            """)
    Iterable<Element> findAllByElemDestination(Element element);
}
