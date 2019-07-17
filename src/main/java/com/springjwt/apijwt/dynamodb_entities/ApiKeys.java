package com.springjwt.apijwt.dynamodb_entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

import java.io.Serializable;


//todo: Need to dynamically add the table name from the environment properties
@Data
@DynamoDBTable(tableName = "localapikeys")
public class ApiKeys implements Serializable {
    @DynamoDBHashKey
    private String key;
    @DynamoDBAttribute
    private String mageId;
    @DynamoDBAttribute
    private String userId;
    @DynamoDBAttribute
    private String email;
    @DynamoDBAttribute
    private String created;
    @DynamoDBAttribute
    private String createdBy;

    public ApiKeys() {
    }

    public ApiKeys(String key, String mageId, String userId, String email, String created, String createdBy) {
        this.key = key;
        this.mageId = mageId;
        this.userId = userId;
        this.email = email;
        this.created = created;
        this.createdBy = createdBy;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMageId() {
        return mageId;
    }

    public void setMageId(String mageId) {
        this.mageId = mageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}

