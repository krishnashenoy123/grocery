package com.grocery.mapper;

import com.grocery.model.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    List<Users> getProfiles();

    int registerUser(Users user);
}
