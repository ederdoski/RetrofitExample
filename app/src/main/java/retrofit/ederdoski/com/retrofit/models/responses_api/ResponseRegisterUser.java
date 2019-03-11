package retrofit.ederdoski.com.retrofit.models.responses_api;

public class ResponseRegisterUser {

    private String token;

    public ResponseRegisterUser(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
