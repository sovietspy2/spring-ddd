package com.example.springddd.repository.customer;

import lombok.*;

import javax.persistence.*;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressProjection {

    private String street;

    private String city;

    private Integer zip;

}
