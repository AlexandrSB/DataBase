package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Parcel;
import com.example.restservice.storageData.storageDomain.Party;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartyRepo extends CrudRepository<Party, Long> {

    @Query("SELECT p FROM Party p LEFT JOIN FETCH p.parcels")
    List<Party> findAllPartiesWithParcels();

    @Query("""
            SELECT p
            FROM Party p
            LEFT JOIN FETCH p.parcels
            WHERE p.id = ?1
            """)
    Optional<Party> findByIdWithParcels(Long id);

    @Query(value = """
            SELECT p.parcels
            FROM Party p
            WHERE p.id = ?1
            """)
    List<Parcel> findAllParcelsWithPartyId(Long id);
}
