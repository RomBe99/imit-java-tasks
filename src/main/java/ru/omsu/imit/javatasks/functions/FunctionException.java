package ru.omsu.imit.javatasks.functions;

public class FunctionException extends Exception {
    public FunctionException(String exceptionInfo) {
        super(exceptionInfo);
    }

    public FunctionException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public FunctionException(Throwable throwable) {
        super(throwable);
    }

    public FunctionException() {
    }

    public FunctionException(double value) {
        super("Not in domain: " + value);
    }
}
