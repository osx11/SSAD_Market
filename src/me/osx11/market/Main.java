package me.osx11.market;

import me.osx11.market.commands.LoginCommand;
import me.osx11.market.exceptions.CommandHandleException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IOException {
        ConsoleProcessor consoleProcessor = ConsoleProcessor.getInstance();
        consoleProcessor.run();
    }
}
