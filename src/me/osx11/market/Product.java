package me.osx11.market;

import java.util.Random;

public class Product implements IProduct {
    private final int id;
    private final String name;

    public Product(String name) {
        this.name = name;

        IMarket market = Market.getInstance();
        int id = new Random().nextInt(1000);

        while (market.hasProduct(id)) {
            id = new Random().nextInt(1000);
        }


        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
