package me.osx11.market;

import me.osx11.market.exceptions.CommandHandleException;

import java.util.List;

public interface ICommand {
    Object[] getArgs();

    void parse() throws CommandHandleException;

    String getRawCommand();
}
