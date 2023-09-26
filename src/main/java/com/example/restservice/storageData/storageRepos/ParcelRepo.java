package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Parcel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
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
            SELECT ps
            FROM Parcel ps
            LEFT JOIN FETCH ps.good
            LEFT JOIN FETCH ps.quantityAccount
            LEFT JOIN FETCH ps.party
            WHERE ps.party.id = ?1
            """)
    Set<Parcel> findAllParcelsWithGoodAndQuandtityAccountAndParty(Long party_id);
}
