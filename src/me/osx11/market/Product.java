package me.osx11.market;

import java.util.ArrayList;
import java.util.List;

public class Product implements IProduct {
    private final int id;
    private final String name;
    private List<String> reviews = new ArrayList<>();

    public Product(String name) {
        this.name = name;
        this.id = this.hashCode() % 1000000;
    }

    /**
     * Returns id of the product
     *
     * @return id of the product
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Returns the name of the product
     *
     * @return the name of the product
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Adds review to the product (adds it into the list) and returns the index of it in the list.
     *
     * @param review review to be saved
     * @return index of the review in the list (it is called review id)
     */
    @Override
    public int addReview(String review) {
        this.reviews.add(review);

        return this.reviews.size() - 1;
    }

    /**
     * Returns review by its id (index of the list)
     *
     * @param id review id (index of the list)
     * @return the review
     */
    @Override
    public String getReview(int id) {
        return this.reviews.get(id);
    }

    /**
     * Removes the review from the list by index (its id)
     * @param id id (index of the list) of the review to remove
     */
    @Override
    public void removeReview(int id) {
        this.reviews.remove(id);
    }

    /**
     * Prints information about all the reviews.
     * Example:
     *
     * REVIEW ID | REVIEW
     * 000000000 | Cool product!
     * 000000001 | Its really good!
     */
    @Override
    public void printReviews() {
        System.out.println("REVIEW ID | REVIEW");

        for (int i = 0; i < this.reviews.size(); i++) {
            String reviewIdString = String.format("%09d", i);
            String review = this.reviews.get(i);

            System.out.println(reviewIdString + " | " + review);
        }
    }
}
