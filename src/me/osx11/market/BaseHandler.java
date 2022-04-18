package me.osx11.market;

import me.osx11.market.exceptions.CommandHandleException;

public abstract class BaseHandler implements IHandler {
    private IHandler next;

    public BaseHandler() {}

    @Override
    public void setNext(IHandler handler) {
        this.next = handler;
    }

    @Override
    public void handleSingle() throws CommandHandleException {
        this.proceed();
    }

    @Override
    public void handle(IRequest request) throws CommandHandleException {
        this.proceed();

        if (this.next != null) {
            this.next.handle(request);
        }
    }

    public abstract void proceed() throws CommandHandleException;
}
