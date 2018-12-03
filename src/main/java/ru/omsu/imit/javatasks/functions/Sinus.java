package ru.omsu.imit.javatasks.functions;

public class Sinus implements Function {
    private LinearPolynomial coefficients;

    public Sinus(LinearPolynomial coefficients) {
        setCoefficients(coefficients);
    }

    public Sinus(double firstCoefficient, double secondCoefficient) {
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
            return 0;
        }

        return coefficients.getFirstCoefficient() * Math.sin(coefficients.getSecondCoefficient() * value);
    }
}
