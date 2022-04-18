package me.osx11.market.requests;

import me.osx11.market.Request;
import me.osx11.market.RequestType;

public class ListProductsRequest extends Request {
    public ListProductsRequest() {
        super(RequestType.PRODUCTS);
    }
}
