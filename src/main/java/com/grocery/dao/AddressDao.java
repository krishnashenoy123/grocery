package com.grocery.dao;

import com.grocery.model.Address;

import java.util.List;

public interface AddressDao {
    List<Address> getAddresses();

    int addAddress(Address address);
}
