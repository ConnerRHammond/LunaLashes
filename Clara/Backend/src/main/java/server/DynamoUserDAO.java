package server;

import DAO.User;

import java.util.HashMap;
import java.util.Iterator;

import Security.Hash;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

public class DynamoUserDAO extends DynamoBaseDAO{
    public DynamoUserDAO() {
        super("Users");
    }


    public String createUser(String alias,String firstName,String lastName, Boolean admin,String password) {
        try {
            password = new Hash().generateStorngPasswordHash(password);
            create(new Item().withPrimaryKey("alias", alias)
                    .withString("firstName", firstName).withString("lastName", lastName)
                    .withString("password",password).withBoolean("admin",admin), table);
            return "Success";
        }catch (Exception e){
            return e.toString();
        }
    }

    public User getUser(String alias,String password) {
        HashMap<String, String> nameMap = new HashMap<String, String>();
        nameMap.put("#f", "alias");
        HashMap<String, Object> valueMap = new HashMap<String, Object>();
        valueMap.put(":g", alias);

        QuerySpec querySpec = new QuerySpec().withKeyConditionExpression("#f = :g").withNameMap(nameMap)
                .withValueMap(valueMap).withScanIndexForward(true);

        ItemCollection<QueryOutcome> items = null;
        try {
            items = table.query(querySpec);
        } catch (Exception e) {
            System.out.println("Failed");
        }

        Item item = null;
        Iterator<Item> iterator = null;
        try {
            iterator = items.iterator();
            item = iterator.next();
            User user = new User(item.getString("firstName"), item.getString("lastName"),
                    item.getString("alias"),item.getBoolean("admin"));
            if (password != null && !Hash.validatePassword(password,item.getString("password"))) {
                return null;
            }
            return user;
        } catch (Exception e) {
            System.out.println("Failed");
        }
        return null;

    }

//    public ItemCollection<QueryOutcome> tableQueryExecuter(HashMap<String, String> nameMap, HashMap<String, Object> valueMap, Table table, String Expression, int Max, ArrayList key,boolean scanIndex) {
//        QuerySpec querySpec;
//        if (Max != 0) {
//            if (key != null) {
//                querySpec = TableQuery(nameMap, valueMap, Max, Expression, key);
//            } else {
//                querySpec = new QuerySpec().withKeyConditionExpression(Expression).withNameMap(nameMap)
//                        .withValueMap(valueMap).withScanIndexForward(scanIndex).withMaxResultSize(Max);
//            }
//        } else {
//            querySpec = new QuerySpec().withKeyConditionExpression(Expression).withNameMap(nameMap)
//                    .withValueMap(valueMap).withScanIndexForward(true);
//        }
//        ItemCollection<QueryOutcome> items = null;
//        try {
//            items = table.query(querySpec);
//        } catch (Exception e) {
//            System.out.println("Failed");
//        }
//        return items;
//    }

//    public User getUser(String alias, String password) {
//        HashMap<String, String> nameMap = new HashMap<String, String>();
//        nameMap.put("#f", "alias");
//        HashMap<String, Object> valueMap = new HashMap<String,Object>();
//        valueMap.put(":g",alias);
//        ItemCollection<QueryOutcome> items = tableQueryExecuter(nameMap,valueMap,table,"#f = :g",0,null,true);
//        Item item = null;
//        Iterator<Item> iterator = null;
//
//        try{
//            iterator = items.iterator();
//            item = iterator.next();
//            User user = new User(item.getString("firstName"), item.getString("lastName"),
//                    item.getString("alias"), item.getString("imageUrl"));
//            if(password != null && !validatePassword(password,item.getString("password"))){
////            if(password != null && !password.equals(item.getString("password"))){
//                return null;
//            }
//            return user;
//        }catch (Exception e){
//            System.out.println("Failed");
//        }
//        return null;
//    }
}
