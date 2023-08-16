package com.example.restservice.equipmentData.equipmentRepos;

import com.example.restservice.equipmentData.equipmentDomain.Group;
import com.example.restservice.equipmentData.equipmentDomain.GroupRecursiveView;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRecursiveRepo extends CrudRepository<GroupRecursiveView, Long> {

    Group getById(Long group_id);

}
