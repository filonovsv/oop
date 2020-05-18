package ru.nsu.ccfit.filonov.commands;

import ru.nsu.ccfit.filonov.Command;
import ru.nsu.ccfit.filonov.Context;
import ru.nsu.ccfit.filonov.exceptions.InvalidCommandException;

public class CommandDefine implements Command {

    @Override
    public void execute(Context context, String[] arguments) throws InvalidCommandException {
        if (arguments.length < 2) {
            throw new InvalidCommandException("More arguments are required for the define command");
        }

        String str1 = arguments[0];
        String str2 = arguments[1];

        try{
            Double.parseDouble(str1);
            throw new InvalidCommandException("First argument not a string");
        }catch(NumberFormatException e){}

        try {
            double value = Double.parseDouble(str2);
            context.setConstant(str1, value);
        } catch (NumberFormatException e) {
            throw new InvalidCommandException(str2 + " is not a number");
        }
    }
}
