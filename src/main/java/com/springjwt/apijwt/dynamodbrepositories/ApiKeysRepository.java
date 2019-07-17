package com.springjwt.apijwt.dynamodbrepositories;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import static com.amazonaws.SDKGlobalConfiguration.ACCESS_KEY_SYSTEM_PROPERTY;
import static com.amazonaws.SDKGlobalConfiguration.SECRET_KEY_SYSTEM_PROPERTY;


@Slf4j
@Component
public class ApiKeysRepository  {

    @Autowired
    public AmazonDynamoDB amazonDynamoDB;

    public void createApiKey() {
        //Table table = dynamoDB.getTable("localapikeys");


// Build the item
//        Item item = new Item()
//                .withPrimaryKey("key", "6ja9K2dNyHE8BCEL9iJlBnLb9ersePia")
//                .withString("mageId", "MAG005311705");
//        PutItemRequest putItemRequest = new PutItemRequest("localapikeys", item);
        //System.setProperty(ACCESS_KEY_SYSTEM_PROPERTY, "localkey"); System.setProperty(SECRET_KEY_SYSTEM_PROPERTY, "localsecret");

        HashMap<String, AttributeValue> item_values =
                new HashMap<String, AttributeValue>();

        item_values.put("key", new AttributeValue("6ja9K2dNyHE8BCEL9iJlBnLb9ersePib"));
        item_values.put("mageId", new AttributeValue("MAGEID"));


        try {
            amazonDynamoDB.putItem("localapikeys", item_values);
        } catch (ResourceNotFoundException e) {
            //System.err.format("Error: The table \"%s\" can't be found.\n", table_name);
            System.err.println("Be sure that it exists and that you've typed its name correctly!");

        }
    }
}
