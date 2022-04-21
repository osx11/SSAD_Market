package me.osx11.market.commands;

import me.osx11.market.BaseCommand;
import me.osx11.market.exceptions.CommandHandleException;

import java.util.Arrays;

public class RegisterCommand extends BaseCommand {
    public static final String usage = "Usage: REGISTER [username] [name] [surname] [password]";

    public RegisterCommand(String rawCommand) throws CommandHandleException {
        super(rawCommand);
    }

    @Override
    public void parse() throws CommandHandleException {
        String[] split = this.getRawCommand().split(" ");

        if (split.length != 5) {
            throw new CommandHandleException(usage);
        }

        String username = split[1];
        String name = split[2];
        String surname = split[3];
        String password = split[4];

        this.setArgs(new String[]{username, name, surname, password});
    }

    @Override
    public void setParameterTypes() {
        this.parameterTypes = Arrays.asList(String.class, String.class, String.class, String.class);
    }
}