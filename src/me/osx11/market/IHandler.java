package me.osx11.market;

import me.osx11.market.exceptions.CommandHandleException;

public interface IHandler {
    /**
     * Sets the next handler. This handler will be used unless the current one can handle the request.
     *
     * @param handler handler to be used next
     */
    void setNext(IHandler handler);

    /**
     * Handles the single request. It differs from BaseHandler::handle in that it do not use the next handler
     * at all, and if the current one cannot handle the request, it will stay that. The method calls BaseHandler::proceed
     * method to deal with the request
     *
     * @throws CommandHandleException An exception thrown during parsing
     */
    void handleSingle() throws CommandHandleException;

    /**
     * Handles the request. If the current handler cannot handle the request, the next one will do that. The method
     * calls BaseHandler::proceed method to deal with the request
     *
     * @param request the request to be handled next
     * @throws CommandHandleException An exception thrown during parsing
     */
    void handle(IRequest request) throws CommandHandleException;
}
