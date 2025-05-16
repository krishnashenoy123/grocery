package com.grocery.mapper;

import com.grocery.model.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    List<Address> getAddresses();

    int addAddress(Address address);

    int  updateAddress(Address address);

    Address getAddressByParams(int user_id, int id);

    int deleteAddress(int id);
}
