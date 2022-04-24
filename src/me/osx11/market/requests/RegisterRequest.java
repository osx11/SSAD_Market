package me.osx11.market.requests;

import me.osx11.market.Request;
import me.osx11.market.RequestType;

public class RegisterRequest extends Request {
    private final String username;
    private final String name;
    private final String surname;
    private final String password;

    public RegisterRequest(String username, String name, String surname, String password) {
        super(RequestType.REGISTER);

        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPassword() {
        return this.password;
    }
}
