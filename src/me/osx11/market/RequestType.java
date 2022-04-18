package me.osx11.market;

import me.osx11.market.handlers.ExitHandler;
import me.osx11.market.handlers.LoginHandler;
import me.osx11.market.handlers.LogoutHandler;
import me.osx11.market.handlers.RegisterHandler;
import me.osx11.market.requests.ExitRequest;
import me.osx11.market.requests.LoginRequest;
import me.osx11.market.requests.LogoutRequest;
import me.osx11.market.requests.RegisterRequest;

public enum RequestType {
    REGISTER(RegisterRequest.class, RegisterHandler.class),
    LOGIN(LoginRequest.class, LoginHandler.class),
    LOGOUT(LogoutRequest.class, LogoutHandler.class),
    EXIT(ExitRequest.class, ExitHandler.class);

    public final Class<? extends Request> requestClass;
    public final Class<? extends BaseHandler> baseHandlerClass;

    RequestType(Class<? extends Request> requestClass, Class<? extends BaseHandler> baseHandlerClass) {
        this.requestClass = requestClass;
        this.baseHandlerClass = baseHandlerClass;
    }
}
