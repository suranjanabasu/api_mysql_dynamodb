package com.springjwt.apijwt.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.springjwt.apijwt.dynamodbrepositories.ApiKeysRepository;
import com.springjwt.apijwt.pojo.UserInfo;
import com.springjwt.apijwt.rdsentities.User;
import com.springjwt.apijwt.rdsrepositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class KeyServiceImpl implements KeysService{

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    ApiKeysRepository apiKeysRepository;

    public String createApiKeys(UserInfo userInfo) {

        //Retrieve the data from mysql using the mageId
        User user = userRepository.findByUid(userInfo.getMageId());

        String key = apiKeysRepository.createApiKey(user);
        if (!StringUtils.isEmpty(key)) {
            //Add the key to user
            user.setApiKey(key);
            userRepository.save(user);
        }
        return key;

    }

    @Override
    public String getKey(String mageId) {
        User user =  userRepository.findByUid(mageId);
        if (!StringUtils.isEmpty(user)) {
            return user.getApiKey();
        }
        return "";

    }


}
