package me.osx11.market;

public interface IClient {
    String getUsername();

    String getName();

    String getSurname();

    boolean isStaff();

    boolean authorize(String password);
}
