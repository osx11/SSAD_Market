package me.osx11.market;

import me.osx11.market.exceptions.CommandHandleException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class ConsoleProcessor {
    private static ConsoleProcessor instance;

    private ConsoleProcessor() {}

    public static ConsoleProcessor getInstance() {
        if (instance == null) {
            instance = new ConsoleProcessor();
        }

        return instance;
    }

    public void run() throws IOException {
        System.out.println("Welcome to the market! Here is the list of all commands:");
        System.out.println();

        try {
            CommandType.printCommands();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                String rawCommand = br.readLine();

                if (rawCommand.length() == 0) {
                    throw new CommandHandleException("Command cannot be empty");
                }

                String commandTypeString = rawCommand.split(" ")[0];

                if (!CommandType.contains(commandTypeString)) {
                    System.out.println("Unknown command. Here is the list of all commands:");
                    System.out.println();

                    CommandType.printCommands();
                    continue;
                }

                Class<? extends BaseCommand> commandClass = CommandType.valueOf(commandTypeString).baseCommandClass;
                BaseCommand command = commandClass.getDeclaredConstructor(String.class).newInstance(rawCommand);
                command.parse(); // if no errors, then the command is correct syntactically, continue

                // parameters' types to get the required Request constructor
                Class<?>[] parameterTypes = new Class[command.getParameterTypes().size()];
                command.getParameterTypes().toArray(parameterTypes);

                Class<? extends Request> requestClass = RequestType.valueOf(commandTypeString).requestClass;
                Request request = requestClass.getDeclaredConstructor(parameterTypes).newInstance(command.getArgs());

                Class<? extends BaseHandler> handlerClass = RequestType.valueOf(commandTypeString).baseHandlerClass;
                BaseHandler handler = handlerClass.getDeclaredConstructor(requestClass).newInstance(request);
                handler.proceed();  // if no errors, then the request was handled successfully, continue
            } catch (CommandHandleException e) { // todo fix
                System.out.println(e.getMessage());
                System.out.println();
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
}
