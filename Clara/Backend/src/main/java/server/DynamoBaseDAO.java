package server;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;

public abstract class DynamoBaseDAO {
    public Table table;
    public DynamoDB dynamoDB;

    public DynamoBaseDAO(String table) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion("us-west-1")
                .build();
        this.dynamoDB= new DynamoDB(client);
        this.table = dynamoDB.getTable(table);
    }

    public String create(Item item, Table table) {
        try {
            table.putItem(item);
            return "Succeded";
        } catch (Exception e) {
            return e.toString();
        }
    }

    public String delete(DeleteItemSpec deleteItemSpec, Table table) {
        try {
            table.deleteItem(deleteItemSpec);
            return "Succeded";
        } catch (Exception e) {
            return e.toString();
        }
    }

    public String update(UpdateItemSpec updateItemSpec, Table table) {
        try {
            table.updateItem(updateItemSpec);
            return "Succeded";
        } catch (Exception e) {
            return e.toString();
        }
    }
}
