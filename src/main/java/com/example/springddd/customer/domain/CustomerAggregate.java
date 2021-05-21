package com.example.springddd.customer.domain;


import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class CustomerAggregate {

    private String name;

    private final Integer id;

    private final Set<CustomerAddressAggregate> customerAddresses;

    public void changeName(String name) {
        // validations
        //idk

        this.name = name;
    }

    private void removeAddress(CustomerAddressAggregate address) {

        // logic


        customerAddresses.remove(address);
    }

    public void addCustomerAddress(CustomerAddressAggregate address) {

        // logic

        this.customerAddresses.add(address);


    }

}
