package com.example.restservice.equipmentData.equipmentRepos;


import com.example.restservice.equipmentData.equipmentDomain.Groups;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupsRepo extends CrudRepository<Groups, Long> {
//    List<Groups> findByName(String groupName);
}
