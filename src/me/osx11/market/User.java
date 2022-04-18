package me.osx11.market;

public class User extends Client {
    public User(String username, String name, String surname, String password) {
        super(username, name, surname, password, false);
    }
}
