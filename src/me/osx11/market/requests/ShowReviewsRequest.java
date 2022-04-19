package me.osx11.market.requests;

import me.osx11.market.Request;
import me.osx11.market.RequestType;

public class ShowReviewsRequest extends Request {
    private final String productId;

    public ShowReviewsRequest(String productId) {
        super(RequestType.SHOWREVIEWS);

        this.productId = productId;
    }


    public String getProductId() {
        return this.productId;
    }
}
