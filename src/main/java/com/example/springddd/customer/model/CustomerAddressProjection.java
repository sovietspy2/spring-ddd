package com.example.springddd.customer.model;

import com.example.springddd.customer.model.key.CustomerAddressCompositeKey;
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
