package me.osx11.market;

import me.osx11.market.exceptions.CommandHandleException;

public interface IHandler {
    void setNext(IHandler handler);

    void handleSingle() throws CommandHandleException;

    void handle(IRequest request) throws CommandHandleException;
}
