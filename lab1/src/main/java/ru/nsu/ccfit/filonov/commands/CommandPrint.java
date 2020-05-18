package ru.nsu.ccfit.filonov.commands;

import ru.nsu.ccfit.filonov.Command;
import ru.nsu.ccfit.filonov.Context;
import ru.nsu.ccfit.filonov.exceptions.ContextEmptyStackException;
import ru.nsu.ccfit.filonov.exceptions.InvalidCommandException;

public class CommandPrint implements Command {
    @Override
    public void execute(Context context, String[] arguments) throws InvalidCommandException {
        double a;
        try {
            a = context.peekAtStack();
        }catch (ContextEmptyStackException e){
            throw new InvalidCommandException(e.getMessage());
        }
        System.out.println("Result: " +a);
    }
}
