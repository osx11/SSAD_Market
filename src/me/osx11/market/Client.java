package me.osx11.market;

public abstract class Client implements IClient {
    private final String username;
    private final String name;
    private final String surname;
    private final String password;
    private final boolean isStaff;

    public Client(String username, String name, String surname, String password, boolean isStaff) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.isStaff = isStaff;
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

    public boolean isStaff() {
        return this.isStaff;
    }

    public boolean authorize(String password) {
        return this.password.contentEquals(password);
    }
}
