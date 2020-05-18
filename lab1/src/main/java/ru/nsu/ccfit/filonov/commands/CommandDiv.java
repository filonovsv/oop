package ru.nsu.ccfit.filonov.commands;

import ru.nsu.ccfit.filonov.Command;
import ru.nsu.ccfit.filonov.Context;
import ru.nsu.ccfit.filonov.exceptions.ContextEmptyStackException;
import ru.nsu.ccfit.filonov.exceptions.InvalidCommandException;

public class CommandDiv implements Command {


    @Override
    public void execute(Context context, String[] arguments) throws InvalidCommandException {
        double a;
        double b;
        try {
            b = context.popFromStack();
            a = context.popFromStack();
        }catch(ContextEmptyStackException e){
            throw new InvalidCommandException(e.getMessage());
        }
        if (a == 0.0){
            throw new InvalidCommandException("biv by zero");
        }
        context.pushToStack(b/a);
    }
}
