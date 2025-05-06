package com.grocery.dao.implementation;

import com.grocery.dao.UsersDao;

import com.grocery.mapper.UsersMapper;
import com.grocery.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> getProfiles() {
        return usersMapper.getProfiles();
    }
}
