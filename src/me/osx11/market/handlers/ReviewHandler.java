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

            // If the similarity of the given review with the template exceeds 70%, then it is marked as faked.
            if (similarity > 70) {
                market.markReviewAsFake(productId, reviewId);
            }
        }

        System.out.println("You review has been submitted!");
        System.out.println();

        request.markHandled();
    }

    /**
     * Damerau–Levenshtein distance algorithm. It is used to compare given review with the template one in order to
     * identify if the given review is fake or not.
     *
     * @param templateReview template review
     * @param review given review
     * @return similarity (Levenshtein distance) of two reviews
     */
    private int compareWithTemplateReview(String templateReview, String review) {
        int templateReviewLength = templateReview.length();
        int reviewLength = review.length();

        if (templateReviewLength == 0) return reviewLength;
        if (reviewLength == 0) return templateReviewLength;
        int[][] dist = new int[templateReviewLength + 1][reviewLength + 1];
        for (int i = 0; i < templateReviewLength + 1; i++) {
            dist[i][0] = i;
        }
        
        for (int j = 0; j < reviewLength + 1; j++) {
            dist[0][j] = j;
        }
        
        for (int i = 1; i < templateReviewLength + 1; i++) {
            for (int j = 1; j < reviewLength + 1; j++) {
                int cost = templateReview.charAt(i - 1) == review.charAt(j - 1) ? 0 : 1;
                dist[i][j] = Math.min(Math.min(dist[i - 1][j] + 1, dist[i][j - 1] + 1), dist[i - 1][j - 1] + cost);
                if (i > 1 && j > 1 && templateReview.charAt(i - 1) == review.charAt(j - 2) && templateReview.charAt(i - 2) == review.charAt(j - 1)) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 2][j - 2] + cost);
                }
            }
        }

        int distance = dist[templateReviewLength][reviewLength];

        int maxLength = Math.max(templateReviewLength, reviewLength);
        int difference = Math.abs(maxLength - distance);

        int similarity = (int)(difference/(double)maxLength * 100.0D);
        return similarity;
    }
}
