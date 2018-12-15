package ru.omsu.imit.javatasks.functions;

public abstract class Functional<T extends Function> implements IFunctional<T> {
    private double top;
    private double bottom;

    public Functional(double top, double bottom) throws FunctionalException {
        setDomain(top, bottom);
    }

    private void setTop(double top) {
        this.top = top;
    }

    private void setBottom(double bottom) throws FunctionalException {
        if (top < bottom) {
            throw new FunctionalException(bottom);
        }

        this.bottom = bottom;
    }

    public void setDomain(double top, double bottom) throws FunctionalException {
        setTop(top);
        setBottom(bottom);
    }

    public double getTop() {
        return top;
    }

    public double getBottom() {
        return bottom;
    }
}