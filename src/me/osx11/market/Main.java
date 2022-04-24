package me.osx11.market;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleProcessor consoleProcessor = ConsoleProcessor.getInstance();
        consoleProcessor.run();
    }
}
