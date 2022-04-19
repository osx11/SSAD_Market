package me.osx11.market;

import java.util.ArrayList;
import java.util.List;

public class Product implements IProduct {
    private final int id;
    private final String name;
    List<String> reviews = new ArrayList<>();

    public Product(String name) {
        this.name = name;
        this.id = this.hashCode() % 1000000;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int addReview(String review) {
        this.reviews.add(review);

        return this.reviews.size() - 1;
    }

    @Override
    public String getReview(int id) {
        return this.reviews.get(id);
    }

    @Override
    public void removeReview(int id) {
        this.reviews.remove(id);
    }

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
