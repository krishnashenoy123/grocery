package com.grocery.service;

import com.grocery.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAdresseses();

    int addAddress(Address address);
}
