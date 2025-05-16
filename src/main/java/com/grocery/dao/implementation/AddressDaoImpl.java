package com.grocery.dao.implementation;

import com.grocery.dao.AddressDao;
import com.grocery.mapper.AddressMapper;
import com.grocery.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDaoImpl implements AddressDao {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> getAddresses() {
        return addressMapper.getAddresses();
    }

    @Override
    public int addAddress(Address address) {
        return addressMapper.addAddress(address);
    }

    @Override
    public int updateAddress(Address address) {
        return addressMapper.updateAddress(address);
    }

    @Override
    public Address getAddressByParams(int user_id, int id) {
        return addressMapper.getAddressByParams(user_id, id);
    }

    @Override
    public int deleteAddress(int id) {
        return addressMapper.deleteAddress(id);
    }
}
