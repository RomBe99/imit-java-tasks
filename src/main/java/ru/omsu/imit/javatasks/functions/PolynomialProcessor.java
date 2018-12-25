package ru.omsu.imit.javatasks.functions;

public class PolynomialProcessor {
    public static double[] findRoots(QuadricPolynomial linearPolynomial) throws FunctionException {
        double D = linearPolynomial.getSecondCoefficient() * linearPolynomial.getSecondCoefficient() - 4 * linearPolynomial.getThirdCoefficient() * linearPolynomial.getFirstCoefficient();
        double temp;

        if (D < 0) {
            throw new FunctionException("The equation has complex roots");
        }

        double[] roots = new double[2];
        temp = -linearPolynomial.getSecondCoefficient() / 2 * linearPolynomial.getThirdCoefficient();

        if (D == 0) {
            roots[0] = temp;
            roots[1] = temp;

            return roots;
        }

        D = Math.sqrt(D) / 2 * linearPolynomial.getThirdCoefficient();
        roots[0] = temp + D;
        roots[1] = temp - D;

        return roots;
    }

    public static double maxRoot(QuadricPolynomial linearPolynomial) throws FunctionException {
        double[] roots = findRoots(linearPolynomial);

        if (roots[0] >= roots[1]) {
            return roots[0];
        }

        return roots[1];
    }
}
