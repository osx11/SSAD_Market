package me.osx11.market;

import java.util.HashMap;

public class Market implements IMarket {
    private static Market instance;
    private IClient currentUser = null; // current user, which is logged in
    private final HashMap<String, IClient> users = new HashMap<>(); // map with all users (key - username, value - Client instance)
    private final HashMap<Integer, IProduct> products = new HashMap<>(); // map with all products (key - product's id, value - Product instance)

    private Market() {}

    public static Market getInstance() {
        if (instance == null) {
            instance = new Market();

            IClient user = new User("user", "Username", "Usernamovich", "123123");
            Client admin = new Admin("admin", "Admin", "Adminovich", "qwerty");

            IProduct product1 = new Product("Test product 1");
            IProduct product2 = new Product("Test product 2");

            instance.addUser(user);
            instance.addUser(admin);

            instance.addProduct(product1);
            instance.addProduct(product2);
        }

        return instance;
    }

    public boolean hasUser(String username) {
        return this.users.containsKey(username);
    }

    public IClient getUser(String username) {
        return this.users.get(username);
    }

    public IClient getCurrentUser() {
        return this.currentUser;
    }

    public void addUser(IClient user) {
        this.users.put(user.getUsername(), user);
    }

    public void setCurrentUser(IClient user) {
        this.currentUser = user;
    }

    public boolean hasProduct(int id) {
        return this.products.containsKey(id);
    }

    public IProduct getProduct(int id) {
        return this.products.get(id);
    }

    public void addProduct(IProduct product) {
        this.products.put(product.getId(), product);
    }
}
