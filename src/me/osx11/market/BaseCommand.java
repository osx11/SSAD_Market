package me.osx11.market;

import me.osx11.market.exceptions.CommandHandleException;

import java.util.List;

public abstract class BaseCommand implements ICommand {
    private final String rawCommand;
    private String[] args;
    protected List<Class<?>> parameterTypes; // they will be used to get the required Request constructor

    public BaseCommand(String rawCommand) throws CommandHandleException {
        this.rawCommand = rawCommand;

        this.preParse();
        this.setParameterTypes();
    }

    @Override
    public Object[] getArgs() {
        return this.args;
    }

    protected void setArgs(String[] args) {
        this.args = args;
    }

    @Override
    public abstract void parse() throws CommandHandleException;

    @Override
    public String getRawCommand() {
        return this.rawCommand;
    }

    private void preParse() throws CommandHandleException {
        if (this.rawCommand.length() == 0) {
            throw new CommandHandleException("Command cannot be empty");
        }
    }

    public abstract void setParameterTypes();

    public List<Class<?>> getParameterTypes() {
        return this.parameterTypes;
    }
}
