package server;
import LamdaObjects.GeneralResponse;
import LamdaObjects.LoginRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LoginHandler  implements RequestHandler<LoginRequest, GeneralResponse> {
    @Override
    public GeneralResponse handleRequest(LoginRequest statusRequest, Context context) {
        return null;
    }
}
