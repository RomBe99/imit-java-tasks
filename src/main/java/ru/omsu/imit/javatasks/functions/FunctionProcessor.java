package ru.omsu.imit.javatasks.functions;

public class FunctionProcessor {
    public static double sumValuesAtTheEndsSegment(Function function) throws FunctionException {
        return function.calculus(function.getBottom()) + function.calculus(function.getTop());
    }

    public static double sumAtTheMiddleSegment(Function function) throws FunctionException {
        return sumValuesAtTheEndsSegment(function) / 2;
    }
}
