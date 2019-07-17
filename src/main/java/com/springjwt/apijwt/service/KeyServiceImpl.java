package com.springjwt.apijwt.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.springjwt.apijwt.dynamodb_entities.ApiKeys;
import com.springjwt.apijwt.dynamodbrepositories.ApiKeysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class KeyServiceImpl implements KeysService{

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    ApiKeysRepository apiKeysRepository;

    public void createApiKeys(String mageId) {

       //todo: Use the mageId and get the user from mysql db

        //public ApiKeys(String key, String mageId, String userId, String email, String created, String createdBy) {
        ApiKeys apiKey = new ApiKeys("6ja9K2dNyHE8BCEL9iJlBnLb9ersePia",
                "312d9df1-e93b-473f-a343-bb67dd16d55b",
                "MAG005311705",
                "some@adobe.com",
                new Date().toString(), "portal");
        apiKeysRepository.createApiKey();


    }


}
