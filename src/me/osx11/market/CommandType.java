package me.osx11.market;

import me.osx11.market.commands.*;

public enum CommandType {
    EXIT(ExitCommand.class),
    REGISTER(RegisterCommand.class),
    LOGIN(LoginCommand.class),
    LOGOUT(LogoutCommand.class),
    ADDPRODUCT(AddProductCommand.class),
    PRODUCTS(ListProductsCommand.class);

    public final Class<? extends BaseCommand> baseCommandClass;

    CommandType(Class<? extends BaseCommand> baseCommandClass) {
        this.baseCommandClass = baseCommandClass;
    }
}
