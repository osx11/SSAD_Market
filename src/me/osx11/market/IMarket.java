package me.osx11.market;

import java.util.List;

public interface IMarket {
    boolean hasUser(String username);

    IClient getUser(String username);

    IClient getCurrentUser();

    void addUser(IClient user);

    void setCurrentUser(IClient user);

    boolean hasProduct(int id);

    IProduct getProduct(int id);

    void addProduct(IProduct userduct);

    List<IProduct> getProducts();

    void printProducts();
}
