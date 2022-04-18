package me.osx11.market;

import me.osx11.market.commands.ExitCommand;
import me.osx11.market.commands.LoginCommand;
import me.osx11.market.commands.LogoutCommand;
import me.osx11.market.commands.RegisterCommand;

public enum CommandType {
    REGISTER(RegisterCommand.class),
    LOGIN(LoginCommand.class),
    LOGOUT(LogoutCommand.class),
    EXIT(ExitCommand.class);

    public final Class<? extends BaseCommand> baseCommandClass;

    CommandType(Class<? extends BaseCommand> baseCommandClass) {
        this.baseCommandClass = baseCommandClass;
    }
}
