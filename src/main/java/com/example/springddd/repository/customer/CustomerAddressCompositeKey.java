package com.example.springddd.repository.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class CustomerAddressCompositeKey implements Serializable {

    private Integer customerId;
    private String street;
    private String city;
    private Integer zip;

}
