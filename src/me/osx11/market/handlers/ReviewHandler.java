package me.osx11.market.handlers;

import me.osx11.market.*;
import me.osx11.market.exceptions.CommandHandleException;
import me.osx11.market.requests.ReviewRequest;

import java.util.Random;

public class ReviewHandler extends BaseHandler {
    private final ReviewRequest request;

    public ReviewHandler(ReviewRequest request) {
        super();
        this.request = request;
    }

    public void proceed() throws CommandHandleException {
        IMarket market = Market.getInstance();

        if (market.getCurrentUser() == null) {
            throw new CommandHandleException("You must login or register first. Use LOGIN or REGISTER command");
        }

        if (market.getCurrentUser().isStaff()) {
            throw new CommandHandleException("Authorized personnel cannot review products.");
        }

        int productId = Integer.parseInt(request.getProductId());
        String productReview = request.getProductReview();

        int reviewId = market.addReview(productId, productReview);;

        if (!((User)market.getCurrentUser()).hasTemplateReview()) {
            // this is the first review of the user, so just add it without any checks

            ((User) market.getCurrentUser()).setTemplateReview(productReview);
        } else {
            String templateReview = ((User) market.getCurrentUser()).getTemplateReview();
            int similarity = this.compareWithTemplateReview(templateReview, productReview);

            if (similarity > 70) {
                market.markReviewAsFake(productId, reviewId);
            }
        }

        System.out.println("You review has been submitted!");
        System.out.println();

        request.markHandled();
    }

    int compareWithTemplateReview(String templateReview, String review) {
        return 80;
//        return new Random().nextInt(100);
    }
}
