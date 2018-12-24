package ru.omsu.imit.javatasks.functions;

public class QuadricPolynomial extends LinearPolynomial {
    private double thirdCoefficient;

    public QuadricPolynomial(double firstCoefficient, double secondCoefficient, double thirdCoefficient) throws FunctionException {
        super(firstCoefficient, secondCoefficient);

        if (thirdCoefficient == 0) {
            throw new FunctionException("The coefficient before x ^ 2 cannot be equal to 0");
        }

        setThirdCoefficient(thirdCoefficient);
    }

    @Override
    public double calculus(double value) throws FunctionException {
        if (value > getTop() || value < getBottom()) {
            throw new FunctionException(value);
        }

        value *= value;

        return thirdCoefficient * thirdCoefficient * value + getSecondCoefficient() * value + getFirstCoefficient();
    }

    public void setThirdCoefficient(double thirdCoefficient) {
        this.thirdCoefficient = thirdCoefficient;
    }

    public double getThirdCoefficient() {
        return thirdCoefficient;
    }
}
