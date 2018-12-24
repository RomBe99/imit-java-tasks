package ru.omsu.imit.javatasks.functions;

public class Integral<T extends Function> extends Functional {

    public Integral(double top, double bottom) throws FunctionalException {
        super(top, bottom);
    }

    @Override
    public double calculate(Function function) throws FunctionException {
        try {
            final int segmentLength = 30;
            final double bottom = getBottom();
            final double lengthSegment = (getTop() - bottom) / segmentLength;
            double integral = 0;

            for (int i = 0; i < segmentLength ; i++) {
                integral += function.calculus(bottom + lengthSegment * (i + 0.5));
            }

            integral *= lengthSegment;

            return integral;
        } catch (FunctionException ex) {
            throw new FunctionalException("Can't calculus the function value in integral range", ex);
        }
    }

    public static void main(String[] args) {
        try {
            Integral integral = new Integral(2,0);
            System.out.println(integral.calculate(new LinearPolynomial(1, 0)));
        } catch (FunctionException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
