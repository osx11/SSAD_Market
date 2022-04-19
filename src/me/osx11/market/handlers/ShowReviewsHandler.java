package me.osx11.market.handlers;

import me.osx11.market.*;
import me.osx11.market.exceptions.CommandHandleException;
import me.osx11.market.requests.ShowReviewsRequest;

public class ShowReviewsHandler extends BaseHandler {
    private final ShowReviewsRequest request;

    public ShowReviewsHandler(ShowReviewsRequest request) {
        super();
        this.request = request;
    }

    public void proceed() throws CommandHandleException {
        IMarket market = Market.getInstance();

        int productId = Integer.parseInt(request.getProductId());

        if (!market.hasProduct(productId)) {
            throw new CommandHandleException("Product with id " + productId + " not found.");
        }

        IProduct product = market.getProduct(productId);

        System.out.println("Here the reviews of the product '" + product.getName() + "':");
        System.out.println();

        product.printReviews();
        System.out.println();

        request.markHandled();
    }
}
