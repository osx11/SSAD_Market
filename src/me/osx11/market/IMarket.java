package me.osx11.market;

public interface IMarket {
    boolean hasUser(String username);

    IClient getUser(String username);

    IClient getCurrentUser();

    void addUser(IClient user);

    void setCurrentUser(IClient user);

    boolean hasProduct(int id);

    IProduct getProduct(int id);

    void addProduct(IProduct userduct);
}
