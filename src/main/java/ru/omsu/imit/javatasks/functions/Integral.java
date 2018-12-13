package ru.omsu.imit.javatasks.functions;

public class Integral<T extends Function> extends Functional {
    public Integral(double top, double bottom, Function function) throws FunctionalException {
        super(top, bottom, function);
    }

    @Override
    public double calculate(IFunction function) throws FunctionalException {
        return 0;
    }
}
