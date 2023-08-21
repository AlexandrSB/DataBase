package com.example.restservice.equipmentData.equipmentRepos;


import com.example.restservice.equipmentData.equipmentDomain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface GroupRepo extends CrudRepository<Group, Long> {
    List<Group> findByGroupName(String groupName);

    Group getById(Long group_id);

}
