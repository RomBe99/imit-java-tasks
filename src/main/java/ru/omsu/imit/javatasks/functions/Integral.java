package ru.omsu.imit.javatasks.functions;

public class Integral<T extends IFunction> extends Functional {
    public Integral(double beginValue, double endValue, T function) {
        super(beginValue, endValue, function);
    }

    //TODO Fix this
    public double calculateIntegral() {
        return 0;
    }
}
