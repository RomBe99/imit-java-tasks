package ru.omsu.imit.javatasks.functions;

public interface IFunctional<T extends Function> {
    double calculate(T function) throws FunctionException;
}
