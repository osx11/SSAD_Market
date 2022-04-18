package me.osx11.market.requests;

import me.osx11.market.Request;
import me.osx11.market.RequestType;

public class LogoutRequest extends Request {
    public LogoutRequest() {
        super(RequestType.LOGOUT);
    }
}
