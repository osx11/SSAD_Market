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

    /**
     * Returns the list of arguments that  will be used for substitution to constructor of Request
     * @return arguments of the command
     */
    @Override
    public Object[] getArgs() {
        return this.args;
    }

    protected void setArgs(String[] args) {
        this.args = args;
    }

    /**
     * Parsing of command is a syntax analysis of it. Parser should check that number of arguments is correct,
     * that the command if not null etc.
     *
     * @throws CommandHandleException An exception thrown during parsing
     */
    @Override
    public abstract void parse() throws CommandHandleException;

    /**
     * @return raw command String without any modification
     */
    @Override
    public String getRawCommand() {
        return this.rawCommand;
    }

    /**
     * Pre parse method should be run before doing main parse. The method checks the command for common syntax
     * errors of raw command that may occur in every raw command input.
     *
     * @throws CommandHandleException An exception thrown during parsing
     */
    private void preParse() throws CommandHandleException {
        if (this.rawCommand.length() == 0) {
            throw new CommandHandleException("Command cannot be empty");
        }
    }

    /**
     * Parameter types are links to classes that will be used in the future to find the correct constructor
     * of Request. E.g. if Request's constructor has the following form: Request(String, String), the method should return
     * a list of two String.class
     */
    public abstract void setParameterTypes();

    /**
     * Parameter types are links to classes (Object.class) that will be used in the future to find the correct constructor
     * of Request. E.g. if Request's constructor has the following form: Request(String, String), the method should return
     * a list of two String.class
     *
     * @return list of Object.class
     */
    public List<Class<?>> getParameterTypes() {
        return this.parameterTypes;
    }
}
