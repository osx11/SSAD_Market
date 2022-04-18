package me.osx11.market;

public abstract class Request implements IRequest {
    private boolean isHandled = false;
    private final RequestType requestType;

    public Request(RequestType requestType) {
        this.requestType = requestType;
    }

    @Override
    public RequestType getRequestType() {
        return this.requestType;
    }

    @Override
    public boolean isHandled() {
        return this.isHandled;
    }

    @Override
    public void markHandled() {
        this.isHandled = true;
    }
}
