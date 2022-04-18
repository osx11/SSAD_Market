package me.osx11.market.handlers;

import me.osx11.market.BaseHandler;
import me.osx11.market.requests.ExitRequest;

public class ExitHandler extends BaseHandler {
    private final ExitRequest request;

    public ExitHandler(ExitRequest request) {
        super();
        this.request = request;
    }

    @Override
    public void proceed() {
        System.out.println("Thank you and good bye!");

        request.markHandled();
        System.exit(0);
    }
}
