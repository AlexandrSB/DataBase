package com.example.restservice.equipmentData.equipmentRepos;


import com.example.restservice.equipmentData.equipmentDomain.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupsRepo extends CrudRepository<Group, Long> {
//    List<Groups> findByName(String groupName);
}
