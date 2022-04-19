package me.osx11.market;

public interface IProduct {
    /**
     * Returns id of the product
     *
     * @return id of the product
     */
    int getId();

    /**
     * Returns the name of the product
     *
     * @return the name of the product
     */
    String getName();

    /**
     * Adds review to the product (adds it into the list) and returns the index of it in the list.
     *
     * @param review review to be saved
     * @return index of the review in the list (it is called review id)
     */
    int addReview(String review);

    /**
     * Returns review by its id (index of the list)
     *
     * @param id review id (index of the list)
     * @return the review
     */
    String getReview(int id);

    /**
     * Removes the review from the list by index (its id)
     * @param id id (index of the list) of the review to remove
     */
    void removeReview(int id);

    /**
     * Prints information about all the reviews.
     * Example:
     *
     * REVIEW ID | REVIEW
     * 000000000 | Cool product!
     * 000000001 | Its really good!
     */
    void printReviews();
}
