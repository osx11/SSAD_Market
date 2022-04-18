package me.osx11.market.commands;

import me.osx11.market.BaseCommand;
import me.osx11.market.exceptions.CommandHandleException;

import java.util.Arrays;

public class LoginCommand extends BaseCommand {
    public LoginCommand(String rawCommand) throws CommandHandleException {
        super(rawCommand);
    }

    @Override
    public void parse() throws CommandHandleException {
        String[] split = this.getRawCommand().split(" ");

        if (split.length != 3) {
            throw new CommandHandleException("Usage: LOGIN [username] [password]");
        }

        String username = split[1];
        String password = split[2];

        this.setArgs(new String[]{username, password});
    }

    @Override
    public void setParameterTypes() {
        this.parameterTypes = Arrays.asList(String.class, String.class);
    }
}
