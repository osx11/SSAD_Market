package me.osx11.market;

public abstract class Request implements IRequest {
    private boolean isHandled = false;
    private final RequestType requestType;

    public Request(RequestType requestType) {
        this.requestType = requestType;
    }

    /**
     * Returns the request type (RequestType enum)
     *
     * @return type of request (RequestType)
     */
    @Override
    public RequestType getRequestType() {
        return this.requestType;
    }

    /**
     * Checks if the request is handled and returns corresponding boolean value
     *
     * @return true if the request is handled, otherwise false
     */
    @Override
    public boolean isHandled() {
        return this.isHandled;
    }

    /**
     * Marks the request as handled (sets isHandled to true)
     */
    @Override
    public void markHandled() {
        this.isHandled = true;
    }
}
