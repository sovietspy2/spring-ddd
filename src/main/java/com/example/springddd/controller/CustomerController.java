package com.example.springddd.controller;

import com.example.springddd.customer.domain.CustomerAggregate;
import com.example.springddd.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

//    @GetMapping
//    public List<CustomerAggregate> getCustomers() {
//        return null;
//    }

    @GetMapping("/{id}")
    public CustomerAggregate getCustomer(@PathVariable Integer id) {
        return customerService.getCustomer(id);
    }



}
