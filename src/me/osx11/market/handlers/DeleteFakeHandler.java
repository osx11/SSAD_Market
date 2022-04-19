package me.osx11.market.handlers;

import me.osx11.market.BaseHandler;
import me.osx11.market.IMarket;
import me.osx11.market.Market;
import me.osx11.market.exceptions.CommandHandleException;
import me.osx11.market.requests.DeleteFakeRequest;
import me.osx11.market.requests.ShowFakeRequest;

public class DeleteFakeHandler extends BaseHandler {
    private final DeleteFakeRequest request;

    public DeleteFakeHandler(DeleteFakeRequest request) {
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

        if (!market.hasFakeReviews()) {
            throw new CommandHandleException("There are no fake reviews.");
        }

        market.deleteFakeReviews();
        System.out.println("All fake reviews have been deleted!");
        System.out.println();

        request.markHandled();
    }
}
