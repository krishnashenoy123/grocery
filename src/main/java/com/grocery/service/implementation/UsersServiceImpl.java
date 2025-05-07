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

    @Override
    public int registerUser(Users user) {
        if (user.getRole() == 0) {  // char default in Java is '\u0000'
            user.setRole('U');
        }

        // Basic validation
        if (user.getFirst_name() == null || user.getUsername() == null || user.getEmail() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Missing required fields: first_name, username, email, or password");
        }

        // TODO: Optionally check if username or email already exists (if you implement it)

        return usersDao.registerUser(user);
    }


}
