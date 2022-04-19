package me.osx11.market;

import java.util.List;

public interface IMarket {
    /**
     * Checks if the user is registered
     *
     * @param username username to check
     * @return true if such a username is registered, otherwise false
     */
    boolean hasUser(String username);

    /**
     * Returns the IClient interface to work with the user by given username
     *
     * @param username username to get the IClient interface
     * @return IClient interface
     */
    IClient getUser(String username);

    /**
     * Returns IClient interface of the user which is currently logged in. If no one is logged in, null will be returned.
     *
     * @return IClient interface of the user which is currently logged in, or null if there is no such user.
     */
    IClient getCurrentUser();

    /**
     * "Registers" (saves) the user to hashmap of all users.
     *
     * @param user IClient interface of the user to be saved
     */
    void addUser(IClient user);

    /**
     * "Logs in" the user. Actually, it saved the IClient interface and emulates that there exists user which
     * inputted his password and it was correct.
     *
     * @param user User to log in (save)
     */
    void setCurrentUser(IClient user);

    /**
     * Checks if the product with given id exists.
     *
     * @param id id of the product to check
     * @return true if the product exists, otherwise false
     */
    boolean hasProduct(int id);

    /**
     * Returns IProduct interface of the product by its id
     *
     * @param id id of the product that is required
     * @return IProduct interface of the product by its id
     */
    IProduct getProduct(int id);

    /**
     * Saves the product to hashmap. The methods emulates creation of product.
     *
     * @param product IProduct interface of the product that is needed to be saved
     */
    void addProduct(IProduct product);

    /**
     * Returns the list of interfaces of all created products
     *
     * @return the list of interfaces of all the existing products
     */
    List<IProduct> getProducts();

    /**
     * Prints information about all created products to console.
     * Example:
     *
     * ID     | NAME
     * 714112 | Test product 2
     * 039532 | Test product 1
     */
    void printProducts();

    /**
     * Prints information about fake reviews.
     * Example:
     *
     * PR. ID | REVIEW ID | REVIEW
     * 039532 | 000000001 | Cool product!
     */
    void printFakeReviews();

    /**
     * Saves the review of the product. The method firstly get the product by its id from the hashmap, then it calls
     * Product::addReview(...) method to add the review. Product::addReview(...) method returns id of saved review, so
     * this method returns it as well.
     *
     * @param productId id of product which if being reviewed
     * @param review a review
     * @return id of the review inside of the product
     */
    int addReview(int productId, String review);

    /**
     * Saves product and review id to hashmap which represents a link to fake review.
     * Key of the hashmap is product id, value is review id. So, such a review can be easily accessed
     * and deleted.
     *
     * @param productId id of the product which contains the review
     * @param reviewId id of the fake review inside the product
     */
    void markReviewAsFake(int productId, int reviewId);

    /**
     * Removes all (fake) reviews from the corresponding hashmap as well as from the product they belong to.
     */
    void deleteFakeReviews();

    /**
     * Checks if the hashmap with the links to fake reviews is empty or not
     *
     * @return false if the corresponding hashmap is empty, otherwise true
     */
    boolean hasFakeReviews();
}
