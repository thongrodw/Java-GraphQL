package com.api.customer.utils;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

public class MongoDB {

    public static void main(String[] args) {

        //Connect to MongoDB
        MongoDatabase database = dbClient("test");
        MongoCollection<Document> users = database.getCollection("users");

        //Insert
        Document toy = new Document("name","toy");
        ObjectId id = users.insertOne(toy).getInsertedId().asObjectId().getValue();
        System.out.println(id);

        //Query
        Document doc = new Document("firstName","Grace");
        Document result = users.find(doc).first();
        System.out.println(result);

    }

    public static MongoDatabase dbClient(String database){
        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        return client.getDatabase(database);
    }


}
