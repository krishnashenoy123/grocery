package com.grocery.service.implementation;

import com.grocery.dao.UsersDao;
import com.grocery.model.Users;
import com.grocery.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public List<Users> getProfiles() {
        return usersDao.getProfiles();
    }
}
