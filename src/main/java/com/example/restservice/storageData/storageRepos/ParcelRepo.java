package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Parcel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParcelRepo extends CrudRepository<Parcel, Long> {
    @Query("SELECT p FROM Parcel p LEFT JOIN FETCH p.parties")
    List<Parcel> findAllWithParties();

    @Query(value = """
            SELECT p
            FROM Parcel p
            LEFT JOIN FETCH p.parties
            WHERE p.id = (
              SELECT pt.parcel_id
              FROM Party pt
              WHERE pt.id = :id
              )
            """)
    List<Parcel> findParcelsFromPartyId(Long id);
}
