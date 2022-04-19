package me.osx11.market.handlers;

import me.osx11.market.BaseHandler;
import me.osx11.market.IMarket;
import me.osx11.market.Market;
import me.osx11.market.User;
import me.osx11.market.exceptions.CommandHandleException;
import me.osx11.market.requests.ReviewRequest;
import me.osx11.market.requests.ShowFakeRequest;

import java.util.Random;

public class ShowFakeHandler extends BaseHandler {
    private final ShowFakeRequest request;

    public ShowFakeHandler(ShowFakeRequest request) {
        super();
        this.request = request;
    }

    public void proceed() throws CommandHandleException {
        IMarket market = Market.getInstance();

        if (market.getCurrentUser() == null) {
            throw new CommandHandleException("You must login or register first. Use LOGIN or REGISTER command");
        }

        if (!market.getCurrentUser().isStaff()) {
            throw new CommandHandleException("Only authorized personnel can see fake reviews.");
        }

        market.printFakeReviews();
        System.out.println();

        request.markHandled();
    }
}
