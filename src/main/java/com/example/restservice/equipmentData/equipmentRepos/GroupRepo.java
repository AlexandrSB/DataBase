package com.example.restservice.equipmentData.equipmentRepos;


import com.example.restservice.equipmentData.equipmentDomain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface GroupRepo extends CrudRepository<Group, Long> {
    List<Group> findByName(String name);

    Group getById(Long group_id);

    Set<Group> findAllById(Optional<Group> group);

    Set<Group> findAllByParentId(Long l);
}
