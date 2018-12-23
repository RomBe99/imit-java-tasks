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

    public double[] findRoots() throws FunctionException {
        double D = getSecondCoefficient() * getSecondCoefficient() - 4 * getFirstCoefficient() * thirdCoefficient;
        double temp;

        if (D < 0) {
            throw new FunctionException("The equation has complex roots");
        }

        double[] roots = new double[2];
        temp = -getSecondCoefficient() / 2 * thirdCoefficient;

        if (D == 0) {
            roots[0] = temp;
            roots[1] = temp;

            return roots;
        }

        D = Math.sqrt(D) / 2 * thirdCoefficient;
        roots[0] = temp + D;
        roots[1] = temp - D;

        return roots;
    }

    public double maxRoot() throws FunctionException {
        double[] roots = findRoots();

        if (roots[0] >= roots[1]) {
            return roots[0];
        }

        return roots[1];
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
