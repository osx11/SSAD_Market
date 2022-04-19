package me.osx11.market;

import me.osx11.market.exceptions.CommandHandleException;

public abstract class BaseHandler implements IHandler {
    private IHandler next;

    public BaseHandler() {}

    /**
     * Sets the next handler. This handler will be used unless the current one can handle the request.
     *
     * @param handler handler to be used next
     */
    @Override
    public void setNext(IHandler handler) {
        this.next = handler;
    }

    /**
     * Handles the single request. It differs from BaseHandler::handle in that it do not use the next handler
     * at all, and if the current one cannot handle the request, it will stay that. The method calls BaseHandler::proceed
     * method to deal with the request
     *
     * @throws CommandHandleException An exception thrown during parsing
     */
    @Override
    public void handleSingle() throws CommandHandleException {
        this.proceed();
    }

    /**
     * Handles the request. If the current handler cannot handle the request, the next one will do that. The method
     * calls BaseHandler::proceed method to deal with the request
     *
     * @param request the request to be handled next
     * @throws CommandHandleException An exception thrown during parsing
     */
    @Override
    public void handle(IRequest request) throws CommandHandleException {
        this.proceed();

        if (this.next != null) {
            this.next.handle(request);
        }
    }

    /**
     * This is the main handler. This method will deal with the request.
     *
     * @throws CommandHandleException An exception thrown during parsing
     */
    public abstract void proceed() throws CommandHandleException;
}
