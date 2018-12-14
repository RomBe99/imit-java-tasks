package ru.omsu.imit.javatasks.functions;

public interface IFunctional<T extends IFunction> {
    double calculate() throws FunctionalException, FunctionException;
}
