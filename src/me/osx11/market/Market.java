package me.osx11.market;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Market implements IMarket {
    private static Market instance;
    private IClient currentUser = null; // current user, which is logged in
    private final Map<String, IClient> users = new HashMap<>(); // map with all users (key - username, value - Client instance)
    private final Map<Integer, IProduct> products = new HashMap<>(); // map with all products (key - product's id, value - Product instance)
    private final Map<Integer, Integer> fakeReviews = new HashMap<>(); // map with "links" to fake reviews (key - product id, value - review id)

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

    public List<IProduct> getProducts() {
        return new ArrayList<>(products.values());
    }

    public void printProducts() {
        System.out.println("ID     | NAME");

        for (IProduct product : this.getProducts()) {
            String productIdString = String.format("%06d", product.getId());
            System.out.println(productIdString + " | " + product.getName());
        }
    }

    @Override
    public void printFakeReviews() {
        System.out.println("PR. ID | REVIEW ID | REVIEW");

        for (int productId : this.fakeReviews.keySet()) {
            String productIdString = String.format("%06d", productId);

            int reviewId = this.fakeReviews.get(productId);
            String reviewIdString = String.format("%09d", reviewId);
            String review = this.products.get(productId).getReview(reviewId);

            System.out.println(productIdString + " | " + reviewIdString + " | " + review);
        }
    }

    @Override
    public int addReview(int productId, String review) {
        return this.products.get(productId).addReview(review);
    }

    @Override
    public void markReviewAsFake(int productId, int reviewId) {
        this.fakeReviews.put(productId, reviewId);
    }

    @Override
    public void deleteFakeReviews() {
        for (int productId : this.fakeReviews.keySet()) {
            this.products.get(productId).removeReview(this.fakeReviews.get(productId));
        }

        this.fakeReviews.clear();
    }

    @Override
    public boolean hasFakeReviews() {
        return !this.fakeReviews.isEmpty();
    }
}
