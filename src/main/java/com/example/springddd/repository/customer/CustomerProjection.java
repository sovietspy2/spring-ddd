package com.example.springddd.repository.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@ToString
public class CustomerProjection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "address", joinColumns = @JoinColumn(name = "customer_id"))
    private Set<CustomerAddressProjection> addresses;


}
