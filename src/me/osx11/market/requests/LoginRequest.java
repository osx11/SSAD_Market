package me.osx11.market.requests;

import me.osx11.market.Request;
import me.osx11.market.RequestType;

public class LoginRequest extends Request {
    private final String username;
    private final String password;

    public LoginRequest(String username, String password) {
        super(RequestType.LOGIN);

        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
