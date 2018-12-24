package ru.omsu.imit.javatasks.functions;

public class FunctionalException extends FunctionException {
    public FunctionalException(String exceptionInfo) {
        super(exceptionInfo);
    }

    public FunctionalException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public FunctionalException(Throwable throwable) {
        super(throwable);
    }

    public FunctionalException() {
    }

    public FunctionalException(double value) {
        super(value);
    }
}
