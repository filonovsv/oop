package ru.nsu.ccfit.filonov.exceptions;

import ru.nsu.ccfit.filonov.CalcException;

public class FactoryGetInstanceException extends CalcException {

    public FactoryGetInstanceException(String message){
        super(message);
    }
}
