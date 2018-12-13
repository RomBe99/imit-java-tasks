package ru.omsu.imit.javatasks.functions;

public class LinearPolynomial implements IFunction {
    private double firstCoefficient;
    private double secondCoefficient;
    private double top;
    private double bottom;

    public LinearPolynomial(double firstCoefficient, double secondCoefficient, double bottom, double top) {
        setFirstCoefficient(firstCoefficient);
        setSecondCoefficient(secondCoefficient);
        setTop(top);
        setBottom(bottom);
    }

    public void setFirstCoefficient(double firstCoefficient) {
        this.firstCoefficient = firstCoefficient;
    }

    public void setSecondCoefficient(double secondCoefficient) {
        this.secondCoefficient = secondCoefficient;
    }

    public void setTop(double top) {
        this.top = top;
    }

    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    public double getFirstCoefficient() {
        return firstCoefficient;
    }

    public double getSecondCoefficient() {
        return secondCoefficient;
    }

    @Override
    public double calculus(double value) throws FunctionException {
        if (value < top || value > bottom) {
            throw new FunctionException(value);
        }
        return firstCoefficient*value + secondCoefficient;
    }

    @Override
    public double getTop() {
        return top;
    }

    @Override
    public double getBottom() {
        return bottom;
    }
}
