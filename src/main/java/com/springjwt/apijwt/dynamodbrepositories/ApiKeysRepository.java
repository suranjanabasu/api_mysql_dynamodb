package com.springjwt.apijwt.dynamodbrepositories;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.util.Base64;
import com.springjwt.apijwt.rdsentities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.springframework.security.crypto.keygen.KeyGenerators.secureRandom;


@Slf4j
@Component
public class ApiKeysRepository  {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

    @Autowired
    public DynamoDB dynamoDB;

    public String createApiKey(User user) {
        Table table = dynamoDB.getTable("localapikeys");
        String apiKey = Base64.encodeAsString(secureRandom(32).generateKey());

        // Build the item
        Item item = new Item()
                .withPrimaryKey("key", apiKey)
                .withString("mageId", user.getUid())
                .withString("userId", user.getExternalId())
                .withString("email", user.getEmail())
                .withString("created", dateFormat.format(Calendar.getInstance().getTime()))
                .withString("createdBy", "portal")
                .withString("enabled", "true");



        // Write the item to the table
        PutItemOutcome outcome = table.putItem(item);
        log.debug("Result is "+outcome.getPutItemResult().toString());
        return apiKey;

    }
}
