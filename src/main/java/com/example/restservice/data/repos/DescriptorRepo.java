package com.example.restservice.data.repos;

import com.example.restservice.data.domain.Descriptor;
import org.springframework.data.repository.CrudRepository;

public interface DescriptorRepo extends CrudRepository<Descriptor, Long> {
}
