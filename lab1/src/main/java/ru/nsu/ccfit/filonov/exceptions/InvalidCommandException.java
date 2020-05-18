package ru.nsu.ccfit.filonov.exceptions;

import ru.nsu.ccfit.filonov.CalcException;

public class InvalidCommandException extends CalcException {

    public InvalidCommandException(String message){
        super(message);
    }
}
