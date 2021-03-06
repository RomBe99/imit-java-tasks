package ru.omsu.imit.javatasks.functions;

public class Exhibitor extends Function implements IFunction {
    private LinearPolynomial coefficients;

    public Exhibitor(LinearPolynomial coefficients, double top, double bottom) throws FunctionException {
        super(top, bottom);
        setCoefficients(coefficients);
    }

    public void setCoefficients(LinearPolynomial coefficients) {
        this.coefficients = coefficients;
    }

    public LinearPolynomial getCoefficients() {
        return coefficients;
    }

    @Override
    public double calculus(double value) throws FunctionException {
        if (!inDomain(value)) {
            throw new FunctionException(value);
        }

        if (coefficients.getSecondCoefficient() == 0) {
            return coefficients.getFirstCoefficient();
        }

        return coefficients.getSecondCoefficient() * Math.exp(value) + coefficients.getFirstCoefficient();
    }
}
