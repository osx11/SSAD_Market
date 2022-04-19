package me.osx11.market.commands;

import me.osx11.market.BaseCommand;
import me.osx11.market.exceptions.CommandHandleException;

import java.util.Collections;

public class DeleteFakeCommand extends BaseCommand {
    public static final String usage = "Usage: DELETEFAKE";

    public DeleteFakeCommand(String rawCommand) throws CommandHandleException {
        super(rawCommand);
    }

    @Override
    public void parse() throws CommandHandleException {}

    @Override
    public void setParameterTypes() {
        this.parameterTypes = Collections.emptyList();
    }
}
