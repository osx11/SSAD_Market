package me.osx11.market.handlers;

import me.osx11.market.*;
import me.osx11.market.exceptions.CommandHandleException;
import me.osx11.market.requests.RegisterRequest;

public class RegisterHandler extends BaseHandler {
    private final RegisterRequest request;

    public RegisterHandler(RegisterRequest request) {
        super();
        this.request = request;
    }

    public void proceed() throws CommandHandleException {
        IMarket market = Market.getInstance();
        String username = request.getUsername();

        if (market.getCurrentUser() != null) {
            throw new CommandHandleException("You are already authorized!");
        }

        if (market.hasUser(username)) {
            throw new CommandHandleException("Such user already exists");
        }

        String name = request.getName();
        String surname = request.getSurname();
        String password = request.getPassword();

        IClient user = new User(username, name, surname, password);
        market.addUser(user);

        System.out.println("Welcome, " + name + " " + surname + "!");
        System.out.println("You account is registered. You can now use LOGIN command.");
        System.out.println();

        request.markHandled();
    }
}
