package me.osx11.market;

public interface IRequest {
    /**
     * Returns the request type (RequestType enum)
     *
     * @return type of request (RequestType)
     */
    RequestType getRequestType();

    /**
     * Checks if the request is handled and returns corresponding boolean value
     *
     * @return true if the request is handled, otherwise false
     */
    boolean isHandled();

    /**
     * Marks the request as handled (sets isHandled to true)
     */
    void markHandled();
}
