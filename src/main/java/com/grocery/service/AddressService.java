package com.grocery.service;

import com.grocery.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAdresseses();

    int addAddress(Address address);

    int updateAddress(Address address);

    Address getAddressByParams(int user_id, int id);

    int deleteAddress(int id);
}
