package me.osx11.market.handlers;

import me.osx11.market.BaseHandler;
import me.osx11.market.requests.ExitRequest;

public class ExitHandler extends BaseHandler {
    private final ExitRequest request;

    public ExitHandler(ExitRequest request) {
        super();
        this.request = request;

        System.out.println("LOGIN HANDLER CREATED");
    }

    @Override
    public void proceed() {
        request.markHandled();
        System.exit(0);
    }
}
