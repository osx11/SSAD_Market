package me.osx11.market.commands;

import me.osx11.market.BaseCommand;
import me.osx11.market.exceptions.CommandHandleException;

import java.util.Collections;

public class AddProductCommand extends BaseCommand {
    public static final String usage = "Usage: ADDPRODUCT [product name]";

    public AddProductCommand(String rawCommand) throws CommandHandleException {
        super(rawCommand);
    }

    @Override
    public void parse() throws CommandHandleException {
        String[] split = this.getRawCommand().split(" ");

        if (split.length < 2) {
            throw new CommandHandleException(usage);
        }

        String productName = this.getRawCommand().replace("ADDPRODUCT ", "");

        this.setArgs(new String[]{productName});
    }

    @Override
    public void setParameterTypes() {
        this.parameterTypes = Collections.singletonList(String.class);
    }
}
