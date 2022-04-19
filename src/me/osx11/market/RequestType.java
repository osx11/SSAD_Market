package me.osx11.market;

import me.osx11.market.handlers.*;
import me.osx11.market.requests.*;

public enum RequestType {
    EXIT(ExitRequest.class, ExitHandler.class),
    REGISTER(RegisterRequest.class, RegisterHandler.class),
    LOGIN(LoginRequest.class, LoginHandler.class),
    LOGOUT(LogoutRequest.class, LogoutHandler.class),
    ADDPRODUCT(AddProductRequest.class, AddProductHandler.class),
    PRODUCTS(ListProductsRequest.class, ListProductsHandler.class),
    REVIEW(ReviewRequest.class, ReviewHandler.class),
    SHOWFAKE(ShowFakeRequest.class, ShowFakeHandler.class),
    SHOWREVIEWS(ShowReviewsRequest.class, ShowReviewsHandler.class),
    DELETEFAKE(DeleteFakeRequest.class, DeleteFakeHandler.class);

    public final Class<? extends Request> requestClass;
    public final Class<? extends BaseHandler> baseHandlerClass;

    RequestType(Class<? extends Request> requestClass, Class<? extends BaseHandler> baseHandlerClass) {
        this.requestClass = requestClass;
        this.baseHandlerClass = baseHandlerClass;
    }
}
