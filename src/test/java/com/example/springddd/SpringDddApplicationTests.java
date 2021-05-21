package com.example.springddd;

import com.example.springddd.repository.customer.CustomerDAO;
import com.example.springddd.domain.customer.CustomerAddress;
import com.example.springddd.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDddApplicationTests {

    @Autowired
    private CustomerService customerService;

    @Test
    void testChangeName() {

        customerService.changeCustomerName(1,"new test name");

        customerService.getCustomer(1);
    }

    @Test
    void testCustomerAddAddress() {
        customerService.addNewAddressToCustomer(new CustomerAddress("wow2", "1234", 1234), 1);
    }

}
