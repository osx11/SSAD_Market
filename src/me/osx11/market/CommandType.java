package me.osx11.market;

import me.osx11.market.commands.*;

public enum CommandType {
    EXIT(ExitCommand.class),
    REGISTER(RegisterCommand.class),
    LOGIN(LoginCommand.class),
    LOGOUT(LogoutCommand.class),
    ADDPRODUCT(AddProductCommand.class),
    PRODUCTS(ListProductsCommand.class),
    REVIEW(ReviewCommand.class),
    SHOWFAKE(ShowFakeCommand.class),
    SHOWREVIEWS(ShowReviewsCommand.class),
    DELETEFAKE(DeleteFakeCommand.class);

    public final Class<? extends BaseCommand> baseCommandClass;

    CommandType(Class<? extends BaseCommand> baseCommandClass) {
        this.baseCommandClass = baseCommandClass;
    }

    public static boolean contains(String commandTypeString) {

        for (CommandType commandType : CommandType.values()) {
            if (commandType.name().equals(commandTypeString)) {
                return true;
            }
        }

        return false;
    }

    public static void printCommands() throws NoSuchFieldException, IllegalAccessException {
        for (CommandType commandType : CommandType.values()) {
            String usage = (String)commandType.baseCommandClass.getDeclaredField("usage").get(null);

            System.out.println("- " + commandType + " (" + usage + ")");
        }

        System.out.println();
    }
}
