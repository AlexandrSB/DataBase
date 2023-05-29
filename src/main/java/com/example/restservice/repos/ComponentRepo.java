package com.example.restservice.repos;

import com.example.restservice.domain.Component;
import org.springframework.data.repository.CrudRepository;

public interface ComponentRepo extends CrudRepository<Component, Long> {
}
