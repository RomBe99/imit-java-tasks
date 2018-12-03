package ru.omsu.imit.javatasks.functions;

public class Exhibitor implements Function {
    private LinearPolynomial coefficients;

    public Exhibitor(LinearPolynomial coefficients) {
        setCoefficients(coefficients);
    }

    public Exhibitor(double firstCoefficient, double secondCoefficient) {
        this(new LinearPolynomial(firstCoefficient, secondCoefficient));
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
    public double calculus(double value) {
        if (coefficients.getFirstCoefficient() == 0) {
            return coefficients.getSecondCoefficient();
        }

        return coefficients.getFirstCoefficient() * Math.exp(value) + coefficients.getSecondCoefficient();
    }
}
