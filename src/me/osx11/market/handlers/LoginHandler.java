package me.osx11.market.handlers;

import me.osx11.market.*;
import me.osx11.market.exceptions.CommandHandleException;
import me.osx11.market.requests.LoginRequest;

public class LoginHandler extends BaseHandler {
    private final LoginRequest request;

    public LoginHandler(LoginRequest request) {
        super();
        this.request = request;
    }

    public void proceed() throws CommandHandleException {
        IMarket market = Market.getInstance();
        String username = request.getUsername();

        if (market.getCurrentUser() != null) {
            throw new CommandHandleException("You are already authorized! Use LOGOUT first");
        }

        if (!market.hasUser(username)) {
            throw new CommandHandleException("Such user does not exist");
        }

        IClient user = market.getUser(username);

        if (!user.authorize(request.getPassword())) {
            throw new CommandHandleException("Wrong password. Try again.");
        }

        market.setCurrentUser(user);

        System.out.println("Welcome, " + user.getName() + " " + user.getSurname() + "!");
        System.out.println("Here is the list of available products! Use REVIEW product to add a review for the product you like:");
        System.out.println();

        market.printProducts();
        System.out.println();

        request.markHandled();
    }
}
