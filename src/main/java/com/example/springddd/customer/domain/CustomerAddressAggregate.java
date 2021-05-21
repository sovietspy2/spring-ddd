package com.example.springddd.customer.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CustomerAddressAggregate {
    private String street;
    private String city;
    private Integer zip;
}
