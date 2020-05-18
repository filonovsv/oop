package ru.nsu.ccfit.filonov.commands;

import ru.nsu.ccfit.filonov.Command;
import ru.nsu.ccfit.filonov.Context;
import ru.nsu.ccfit.filonov.exceptions.ContextEmptyStackException;
import ru.nsu.ccfit.filonov.exceptions.InvalidCommandException;

public class CommandSqrt implements Command {
    @Override
    public void execute(Context context, String[] arguments) throws InvalidCommandException {

        double a;

        try {
            a = context.popFromStack();
        }catch (ContextEmptyStackException e){
            throw new InvalidCommandException(e.getMessage());
        }
        if (a<0){
            throw new InvalidCommandException("It is not possible to extract the root from a negative number");
        }

        context.pushToStack( Math.sqrt(a) );
    }
}
