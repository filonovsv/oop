package ru.nsu.ccfit.filonov;


import ru.nsu.ccfit.filonov.exceptions.InvalidCommandException;

public interface Command {
    public void execute(Context context, String[] arguments) throws InvalidCommandException, InvalidCommandException;
}
