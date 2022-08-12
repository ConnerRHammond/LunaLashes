import server.DynamoUserDAO;

public class Testing {

    public static void main(String[] args) {
        DynamoUserDAO dao = new DynamoUserDAO();
       // dao.createUser("Reuelerman@gmail.com","Conner","Hammond",true,"Vinadelmar2016!");

        System.out.print(dao.getUser("Reuelerman@gmail.com","Vinadelmar2016!").getFirstName());
    }
}
