package com.springjwt.apijwt.service;


import com.springjwt.apijwt.rdsentities.User;
import com.springjwt.apijwt.pojo.UserInfo;

public interface UserService {


    UserInfo retrieveAuthUserDetails(String code);

    User retrieveOrCreateUser(UserInfo userInfo);
}
