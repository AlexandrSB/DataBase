package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Parcel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ParcelRepo extends CrudRepository<Parcel, Long> {
    @Query(value = """
            SELECT p.parcels
            FROM Party p
            WHERE p.id = ?1
            """)
    Set<Parcel> findParcelsFromPartyId(Long party_id);

    @Query(value = """
            SELECT p
            FROM Parcel p
                LEFT JOIN FETCH p.good g
                LEFT JOIN FETCH p.quantityAccount qa
                LEFT JOIN FETCH p.party pt
            """)
    Iterable<Parcel> findAllParcelsWithLazy();

    @Query(value = """
            SELECT p
            FROM Parcel p
                LEFT JOIN FETCH p.good g
                LEFT JOIN FETCH p.quantityAccount qa
                LEFT JOIN FETCH p.party pt
            WHERE pt.id = :partyId
            """)
    Iterable<Parcel> findAllParcelsByPartyId(Long partyId);
}
