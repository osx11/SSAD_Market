package me.osx11.market.commands;

import me.osx11.market.BaseCommand;
import me.osx11.market.exceptions.CommandHandleException;

import java.util.Arrays;
import java.util.Collections;

public class ShowReviewsCommand extends BaseCommand {
    public static final String usage = "Usage: SHOWREVIEWS [product ID]";

    public ShowReviewsCommand(String rawCommand) throws CommandHandleException {
        super(rawCommand);
    }

    @Override
    public void parse() throws CommandHandleException {
        String[] split = this.getRawCommand().split(" ");

        if (split.length != 2) {
            throw new CommandHandleException(usage);
        }

        String productIdString = split[1];
        this.setArgs(new String[]{productIdString});
    }

    @Override
    public void setParameterTypes() {
        this.parameterTypes = Collections.singletonList(String.class);
    }
}
