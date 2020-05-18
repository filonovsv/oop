package ru.nsu.ccfit.filonov.commands;

import ru.nsu.ccfit.filonov.Command;
import ru.nsu.ccfit.filonov.Context;
import ru.nsu.ccfit.filonov.exceptions.ContextNotSetConstantException;
import ru.nsu.ccfit.filonov.exceptions.InvalidCommandException;

public class CommandPush implements Command {
    @Override
    public void execute(Context context, String[] arguments) throws InvalidCommandException {
        double arg;
        try {
            arg = Double.parseDouble(arguments[0]);
        } catch (NumberFormatException nfe) {
            try {
                arg = context.getConstant(arguments[0]);
            }catch (ContextNotSetConstantException ce){
                throw new InvalidCommandException(ce.getMessage());
            }
        }
        context.pushToStack(arg);
    }
}
