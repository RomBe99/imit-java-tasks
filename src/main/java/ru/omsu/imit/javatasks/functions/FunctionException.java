package ru.omsu.imit.javatasks.functions;

public class FunctionException extends Exception {
    public FunctionException(String exceptionInfo) {
        super(exceptionInfo);
    }

    public FunctionException(double value) {
        super("Not in domain: " + value);
    }
}
