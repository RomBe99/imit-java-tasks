package ru.omsu.imit.javatasks.functions;

public abstract class Function implements IFunction {
    private double top;
    private double bottom;

    public Function(double top, double bottom) throws FunctionException {
        setDomain(top, bottom);
    }

    public void setDomain(double top, double bottom) throws FunctionException {
        if (top < bottom) {
            throw new FunctionException(bottom);
        }

        this.bottom = bottom;
        this.top = top;
    }

    public double getTop() {
        return top;
    }

    public double getBottom() {
        return bottom;
    }

    public boolean inDomain(double value) {
        return top >= value && value >= bottom;
    }
}
