package me.osx11.market;

import me.osx11.market.exceptions.CommandHandleException;

public interface ICommand {
    /**
     * Returns the list of arguments that  will be used for substitution to constructor of Request
     * @return arguments of the command
     */
    Object[] getArgs();

    /**
     * Parsing of command is a syntax analysis of it. Parser should check that number of arguments is correct,
     * that the command if not null etc.
     *
     * @throws CommandHandleException An exception thrown during parsing
     */
    void parse() throws CommandHandleException;

    /**
     * @return raw command String without any modification
     */
    String getRawCommand();
}
