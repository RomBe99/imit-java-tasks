package ru.omsu.imit.javatasks.functions;

public class LinearPolynomial extends Function implements IFunction {
    private double firstCoefficient;
    private double secondCoefficient;

    public LinearPolynomial(double firstCoefficient, double secondCoefficient) throws FunctionException {
        super(Double.MAX_VALUE, Double.MIN_VALUE);
        setFirstCoefficient(firstCoefficient);
        setSecondCoefficient(secondCoefficient);
    }

    public void setFirstCoefficient(double firstCoefficient) {
        this.firstCoefficient = firstCoefficient;
    }

    public void setSecondCoefficient(double secondCoefficient) {
        this.secondCoefficient = secondCoefficient;
    }

    public double getFirstCoefficient() {
        return firstCoefficient;
    }

    public double getSecondCoefficient() {
        return secondCoefficient;
    }

    @Override
    public double calculus(double value) throws FunctionException {
        if (value > getTop() || value < getBottom()) {
            throw new FunctionException(value);
        }

        return firstCoefficient * value + secondCoefficient;
    }
}
