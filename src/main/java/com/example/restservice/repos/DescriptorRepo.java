package com.example.restservice.repos;

import com.example.restservice.domain.Descriptor;
import org.springframework.data.repository.CrudRepository;

public interface DescriptorRepo extends CrudRepository<Descriptor, Long> {
}
