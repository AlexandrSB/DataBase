package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Party;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartyRepo extends CrudRepository<Party, Long> {
    @Query(name = "Party.findAllWithQuantities",
           value = """
                   SELECT p FROM Party p
                   LEFT JOIN FETCH p.quantityAccount
                   """)
    List<Party> findFullParty();
}
