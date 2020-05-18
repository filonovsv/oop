package ru.nsu.ccfit.filonov.exceptions;

import ru.nsu.ccfit.filonov.CalcException;

public class ContextEmptyStackException extends CalcException {

    public ContextEmptyStackException(String message){
        super(message);
    }
}
