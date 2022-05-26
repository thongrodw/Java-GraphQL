package com.api.customer.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Address {

    private String country;
    private String street;
    private String city;
    private String postCode;
}

