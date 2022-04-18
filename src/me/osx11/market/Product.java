package me.osx11.market;

public class Product implements IProduct {
    private final int id;
    private final String name;

    public Product(String name) {
        this.name = name;
        this.id = this.hashCode() % 1000000;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
