package ru.omsu.imit.javatasks.functions;

public abstract class Functional<T extends Function> implements IFunctional<T> {
    private double top;
    private double bottom;
    private T function;

    public Functional(double top, double bottom, T function) throws FunctionalException {
        if (!function.inDomain(top) || !function.inDomain(bottom)) {
            throw new FunctionalException();
        }

        setTop(top);
        setBottom(bottom);
        setFunction(function);
    }

    private void setTop(double top) {
        this.top = top;
    }

    private void setBottom(double bottom) throws FunctionalException {
        if (top < bottom) {
            throw new FunctionalException();
        }

        this.bottom = bottom;
    }

    private void setFunction(T function) {
        this.function = function;
    }

    public double getTop() {
        return top;
    }

    public double getBottom() {
        return bottom;
    }

    public T getFunction() {
        return function;
    }
}
