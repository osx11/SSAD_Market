package me.osx11.market.handlers;

import me.osx11.market.BaseHandler;
import me.osx11.market.IMarket;
import me.osx11.market.Market;
import me.osx11.market.exceptions.CommandHandleException;
import me.osx11.market.requests.LogoutRequest;

public class LogoutHandler extends BaseHandler {
    private final LogoutRequest request;

    public LogoutHandler(LogoutRequest request) {
        super();
        this.request = request;
    }

    @Override
    public void proceed() throws CommandHandleException {
        IMarket market = Market.getInstance();

        if (market.getCurrentUser() == null) {
            throw new CommandHandleException("You are not logged in. Use LOGIN command to login.");
        }

        market.setCurrentUser(null);

        System.out.println("Successfully logged out!");
        System.out.println();

        request.markHandled();
    }
}
