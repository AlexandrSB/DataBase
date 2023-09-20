package com.example.restservice.storageData.storageRepos;

import com.example.restservice.storageData.storageDomain.Party;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartyRepo extends CrudRepository<Party, Long> {
}
