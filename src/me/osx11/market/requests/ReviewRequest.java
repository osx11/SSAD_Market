package me.osx11.market.requests;

import me.osx11.market.Request;
import me.osx11.market.RequestType;

public class ReviewRequest extends Request {
    private final String productId;
    private final String productReview;

    public ReviewRequest(String productId, String productReview) {
        super(RequestType.REVIEW);

        this.productId = productId;
        this.productReview = productReview;
    }


    public String getProductId() {
        return this.productId;
    }

    public String getProductReview() {
        return this.productReview;
    }
}
