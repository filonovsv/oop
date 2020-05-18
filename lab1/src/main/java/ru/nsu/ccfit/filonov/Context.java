package ru.nsu.ccfit.filonov;


import ru.nsu.ccfit.filonov.exceptions.ContextEmptyStackException;
import ru.nsu.ccfit.filonov.exceptions.ContextNotSetConstantException;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.TreeMap;

public class Context {
    private Stack<Double> calcStack = new Stack<Double>();
    private TreeMap<String, Double> constants = new TreeMap<String, Double>();

    public double getConstant(String var) throws ContextNotSetConstantException {
        if (!constants.containsKey(var)) {
            throw new ContextNotSetConstantException("not set constant " +var);
        }
        return constants.get(var);
    }

    public void setConstant(String var, Double value) {
        constants.put(var, value);
    }

    public void pushToStack(double value) {
        calcStack.push(value);
    }

    public double popFromStack() throws ContextEmptyStackException {
        try {
            return calcStack.pop();
        } catch (EmptyStackException e) {
            throw new ContextEmptyStackException(e.getMessage());
        }
    }

    public double peekAtStack() throws ContextEmptyStackException {
        try {
            return calcStack.peek();
        } catch (EmptyStackException e) {
            throw new ContextEmptyStackException(e.getMessage());
        }
    }
}