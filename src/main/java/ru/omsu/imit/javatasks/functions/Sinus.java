package ru.omsu.imit.javatasks.functions;

public class Sinus extends Function implements IFunction {
    private LinearPolynomial coefficients;

    public Sinus(LinearPolynomial coefficients, double top, double bottom) throws FunctionException {
        super(top, bottom);
        setCoefficients(coefficients);
    }

    public void setCoefficients(LinearPolynomial coefficients) {
        if (coefficients == null) {
            throw new NullPointerException();
        }

        this.coefficients = coefficients;
    }

    public LinearPolynomial getCoefficients() {
        return coefficients;
    }

    @Override
    public double calculus(double value) throws FunctionException {
        if (value < getTop() || value > getBottom()) {
            throw new FunctionException(value);
        }

        if (coefficients.getSecondCoefficient() == 0) {
            return 0;
        }

        return coefficients.getSecondCoefficient() * Math.sin(coefficients.getFirstCoefficient() * value);
    }
}
