package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ElementRepo extends CrudRepository<Element, Long> {

    @Override
    @Query(value = """
            SELECT e
            FROM Element e
                LEFT JOIN FETCH e.groups g
            ORDER BY e.category, g.id, e.name
            """)
    Iterable<Element> findAll();

    @Override
    Optional<Element> findById(Long aLong);

    Optional<Element> findByName(String compName);

    @Query(value = """
            SELECT e.name
            FROM Element e
            """)
    Iterable<Element> findAllOnlyName();

    @Query(value = """
            SELECT  e.id, e.name,
            		ed.id, ed.name,
            		px.id, px.name       
            	FROM Element e
            LEFT JOIN FETCH ElementsComposite ec
            	ON e = ec.element_destination
            LEFT JOIN FETCH Proxy px
            	ON ec.proxy = px
            LEFT JOIN FETCH Element ed
            	ON ec.element_source = ed
            WHERE e.id = :id
            GROUP BY e.id, ed.id, px.id         
            """)
    Iterable<String> findElementDestination(Long id);

    @Query(value = """
            SELECT  e,
            		ed,
            		px       
            	FROM Element e
            LEFT JOIN FETCH ElementsComposite ec
            	ON e = ec.element_destination
            LEFT JOIN FETCH Proxy px
            	ON ec.proxy = px
            LEFT JOIN FETCH Element ed
            	ON ec.element_source = ed
            WHERE e.id = :id
            GROUP BY e.id, ed.id, px.id         
            """)
    Iterable<Element> findElementDestinationAll(Long id);
    @Query(value = """
            SELECT  e.id, e.name,
            		es.id, es.name,
            		px.id, px.name       
            	FROM Element e
            LEFT JOIN FETCH ElementsComposite ec
            	ON e = ec.element_source
            LEFT JOIN FETCH Proxy px
            	ON ec.proxy = px
            LEFT JOIN FETCH Element es
            	ON ec.element_destination = es
            WHERE e.id = :id
            GROUP BY e.id, es.id, px.id         
            """)
    Iterable<String> findElementSource(Long id);

    @Query(value = """
            SELECT  e, px, es      
            	FROM Element e
            LEFT JOIN FETCH ElementsComposite ec
            	ON e = ec.element_source
            LEFT JOIN FETCH Proxy px
            	ON ec.proxy = px
            LEFT JOIN FETCH Element es
            	ON ec.element_destination = es
            WHERE e.id = :id
            GROUP BY e.id, es.id, px.id         
            """)
    Iterable<Element> findElementSourceAll(Long id);
    @Query(value= """
            SELECT e.name
            FROM Element e
            WHERE e.category = 0
            """)
    Set<String> findEquipmentsOnlyName();

    @Query(value= """
            SELECT e.name
            FROM Element e
            WHERE e.category = 1
            """)
    Set<String> findParcelsOnlyName();

    @Query(value= """
            SELECT e
            FROM Element e
            WHERE e.category = 0
            ORDER BY e.name
            """)
    Iterable<Element> findAllEquipment();

    @Query(value= """
            SELECT e
            FROM Element e
            WHERE e.category = 1
            """)
    Iterable<Element> findAllParcels();

    @Query(value = """
            SELECT e.id
            FROM Element e
            WHERE e.category = 1
            """)
    Iterable<Long> findAllParcelsId();

    @Query(value = """
            SELECT px       
            	FROM Element e
            LEFT JOIN FETCH ElementsComposite ec
            	ON e = ec.element_destination
            LEFT JOIN FETCH Proxy px
            	ON ec.proxy = px
            LEFT JOIN FETCH Element ed
            	ON ec.element_source = ed
            WHERE e.id = :id
            """)
    Iterable<Element> findAllProxy(Long id);
}
