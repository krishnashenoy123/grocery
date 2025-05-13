package com.grocery.service.implementation;

import com.grocery.dao.AddressDao;
import com.grocery.model.Address;
import com.grocery.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public List<Address> getAdresseses() {
        return addressDao.getAddresses();
    }

    @Override
    public int addAddress(Address address) {
        return addressDao.addAddress(address);
    }
}
