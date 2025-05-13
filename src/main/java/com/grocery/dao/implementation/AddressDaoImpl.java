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
}
