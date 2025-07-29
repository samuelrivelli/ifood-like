package org.example.order;

import lombok.Setter;

public class Address implements Cloneable {
    @Setter
    private String street;
    private String city;
    private String zipCode;

    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getZipCode() {
        return zipCode;
    }

    @Override
    public Address clone() {
        return new Address(this.street, this.city, this.zipCode);
    }
}
