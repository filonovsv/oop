package ru.nsu.ccfit.filonov.exceptions;

import ru.nsu.ccfit.filonov.CalcException;

public class ContextNotSetConstantException extends CalcException {
    public ContextNotSetConstantException(String message){
        super(message);
    }
}
