package me.osx11.market;

public interface IProduct {
    int getId();

    String getName();

    int addReview(String review);

    String getReview(int id);

    void removeReview(int id);

    void printReviews();
}
