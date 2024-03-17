package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.Category;
import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentDomain.Proxy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProxyRepo extends CrudRepository<Proxy, Long> {

	@Query(value = """
			SELECT p
			FROM Proxy p
			ORDER BY p.category, p.elementType, p.name
			""")
	Iterable<Proxy> findAll();

    Optional<Proxy> findByName(String proxyDestination);

    @Query(value = """
            SELECT e.proxies
            FROM Element e
            WHERE e.id = ?1
            """)
    Iterable<Proxy> findByElement(Long elemId);

	@Query(value = """
			SELECT p
			FROM Proxy p
			WHERE p.category = :category
			""")
	Iterable<Proxy> findAllByCategory(Category category);

}
