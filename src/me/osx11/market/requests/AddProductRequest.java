package me.osx11.market.requests;

import me.osx11.market.Request;
import me.osx11.market.RequestType;

public class AddProductRequest extends Request {
    private final String productName;

    public AddProductRequest(String productName) {
        super(RequestType.ADDPRODUCT);

        this.productName = productName;
    }


    public String getProductName() {
        return this.productName;
    }
}
