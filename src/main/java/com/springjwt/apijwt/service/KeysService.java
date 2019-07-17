package com.springjwt.apijwt.service;


import com.springjwt.apijwt.pojo.UserInfo;
import com.springjwt.apijwt.rds_entities.User;

public interface KeysService {

    String createApiKeys(UserInfo userInfo);

    String getKey(String mageId);
}
