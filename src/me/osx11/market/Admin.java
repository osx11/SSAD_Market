package me.osx11.market;

public class Admin extends Client {
    public Admin(String username, String name, String surname, String password) {
        super(username, name, surname, password, true);
    }
}
