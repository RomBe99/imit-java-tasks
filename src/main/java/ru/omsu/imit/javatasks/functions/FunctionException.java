package ru.omsu.imit.javatasks.functions;

public class FunctionException extends Exception {
    public FunctionException(double value) {
        super("Not in domain: " + value);
    }
}
