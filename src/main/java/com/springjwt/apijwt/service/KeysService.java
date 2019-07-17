package com.springjwt.apijwt.service;


import com.springjwt.apijwt.pojo.UserInfo;


public interface KeysService {

    String createApiKeys(UserInfo userInfo);

    String getKey(String mageId);
}
