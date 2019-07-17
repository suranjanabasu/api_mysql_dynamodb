package com.springjwt.apijwt.service;


import com.springjwt.apijwt.rds_entities.User;
import com.springjwt.apijwt.pojo.UserInfo;

public interface UserService {


    public UserInfo retrieveAuthUserDetails(String code);

    public User retrieveOrCreateUser(UserInfo userInfo);
}
