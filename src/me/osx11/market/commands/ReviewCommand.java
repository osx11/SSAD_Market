package me.osx11.market.commands;

import me.osx11.market.BaseCommand;
import me.osx11.market.exceptions.CommandHandleException;

import java.util.Arrays;

public class ReviewCommand extends BaseCommand {
    public static final String usage = "Usage: REVIEW [product ID] [your_review]";

    public ReviewCommand(String rawCommand) throws CommandHandleException {
        super(rawCommand);
    }

    @Override
    public void parse() throws CommandHandleException {
        String[] split = this.getRawCommand().split(" ");

        if (split.length < 3) {
            throw new CommandHandleException(usage);
        }

        String productIdString = split[1];
        String productReview = this.getRawCommand().replace("REVIEW " + productIdString + " ", "");

        this.setArgs(new String[]{productIdString, productReview});
    }

    @Override
    public void setParameterTypes() {
        this.parameterTypes = Arrays.asList(String.class, String.class);
    }
}
