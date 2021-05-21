package com.example.springddd.customer;

import com.example.springddd.customer.model.CustomerProjection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDAO extends CrudRepository<CustomerProjection, Integer> {

    Optional<CustomerProjection> findById(Integer id);
}
