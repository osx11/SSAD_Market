package me.osx11.market.requests;

import me.osx11.market.Request;
import me.osx11.market.RequestType;

public class DeleteFakeRequest extends Request {
    public DeleteFakeRequest() {
        super(RequestType.DELETEFAKE);
    }
}
