package LamdaObjects;

public class LoginResponse extends GeneralResponse {
    public boolean admin;
    public String authToken;
    public LoginResponse(boolean sucess, String message,Boolean admin, String authToken) {
        super(sucess,message);
        this.admin = admin;
        this.authToken = authToken;
    }
}
