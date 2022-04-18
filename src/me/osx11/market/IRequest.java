package me.osx11.market;

public interface IRequest {
    RequestType getRequestType();

    boolean isHandled();

    void markHandled();
}
