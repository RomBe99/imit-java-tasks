package ru.omsu.imit.javatasks.functions;

public class FunctionalException extends FunctionException {
    public FunctionalException(String exceptionInfo) {
        super(exceptionInfo);
    }

    public FunctionalException(double value) {
        super(value);
    }
}
