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

    /**
     * Checks if the user is registered
     *
     * @param username username to check
     * @return true if such a username is registered, otherwise false
     */
    public boolean hasUser(String username) {
        return this.users.containsKey(username);
    }

    /**
     * Returns the IClient interface to work with the user by given username
     *
     * @param username username to get the IClient interface
     * @return IClient interface
     */
    public IClient getUser(String username) {
        return this.users.get(username);
    }

    /**
     * Returns IClient interface of the user which is currently logged in. If no one is logged in, null will be returned.
     *
     * @return IClient interface of the user which is currently logged in, or null if there is no such user.
     */
    public IClient getCurrentUser() {
        return this.currentUser;
    }

    /**
     * "Registers" (saves) the user to hashmap of all users.
     *
     * @param user IClient interface of the user to be saved
     */
    public void addUser(IClient user) {
        this.users.put(user.getUsername(), user);
    }

    /**
     * "Logs in" the user. Actually, it saved the IClient interface and emulates that there exists user which
     * inputted his password and it was correct.
     *
     * @param user User to log in (save)
     */
    public void setCurrentUser(IClient user) {
        this.currentUser = user;
    }

    /**
     * Checks if the product with given id exists.
     *
     * @param id id of the product to check
     * @return true if the product exists, otherwise false
     */
    public boolean hasProduct(int id) {
        return this.products.containsKey(id);
    }

    /**
     * Returns IProduct interface of the product by its id
     *
     * @param id id of the product that is required
     * @return IProduct interface of the product by its id
     */
    public IProduct getProduct(int id) {
        return this.products.get(id);
    }

    /**
     * Saves the product to hashmap. The methods emulates creation of product.
     *
     * @param product IProduct interface of the product that is needed to be saved
     */
    public void addProduct(IProduct product) {
        this.products.put(product.getId(), product);
    }

    /**
     * Returns the list of interfaces of all created products
     *
     * @return the list of interfaces of all the existing products
     */
    public List<IProduct> getProducts() {
        return new ArrayList<>(products.values());
    }

    /**
     * Prints information about all created products to console.
     * Example:
     *
     * ID     | NAME
     * 714112 | Test product 2
     * 039532 | Test product 1
     */
    public void printProducts() {
        System.out.println("ID     | NAME");

        for (IProduct product : this.getProducts()) {
            String productIdString = String.format("%06d", product.getId());
            System.out.println(productIdString + " | " + product.getName());
        }
    }

    /**
     * Prints information about fake reviews.
     * Example:
     *
     * PR. ID | REVIEW ID | REVIEW
     * 039532 | 000000001 | Cool product!
     */
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

    /**
     * Saves the review of the product. The method firstly get the product by its id from the hashmap, then it calls
     * Product::addReview(...) method to add the review. Product::addReview(...) method returns id of saved review, so
     * this method returns it as well.
     *
     * @param productId id of product which if being reviewed
     * @param review a review
     * @return id of the review inside of the product
     */
    @Override
    public int addReview(int productId, String review) {
        return this.products.get(productId).addReview(review);
    }

    /**
     * Saves product and review id to hashmap which represents a link to fake review.
     * Key of the hashmap is product id, value is review id. So, such a review can be easily accessed
     * and deleted.
     *
     * @param productId id of the product which contains the review
     * @param reviewId id of the fake review inside the product
     */
    @Override
    public void markReviewAsFake(int productId, int reviewId) {
        this.fakeReviews.put(productId, reviewId);
    }

    /**
     * Removes all (fake) reviews from the corresponding hashmap as well as from the product they belong to.
     */
    @Override
    public void deleteFakeReviews() {
        for (int productId : this.fakeReviews.keySet()) {
            this.products.get(productId).removeReview(this.fakeReviews.get(productId));
        }

        this.fakeReviews.clear();
    }

    /**
     * Checks if the hashmap with the links to fake reviews is empty or not
     *
     * @return false if the corresponding hashmap is empty, otherwise true
     */
    @Override
    public boolean hasFakeReviews() {
        return !this.fakeReviews.isEmpty();
    }
}
