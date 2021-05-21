package com.example.springddd.domain.customer;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class CustomerAddress {
    private String street;
    private String city;
    private Integer zip;
}
