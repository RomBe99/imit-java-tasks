package ru.omsu.imit.javatasks.functions;

public class Integral extends Functional {

    public Integral(double top, double bottom) throws FunctionalException {
        super(top, bottom);
    }

    @Override
    public double calculate(Function function) throws FunctionException {
        final double top = getTop();
        if (!function.inDomain(top)) {
            throw new FunctionalException(top);
        }

        final double bottom = getBottom();
        if (!function.inDomain(bottom)) {
            throw new FunctionalException(bottom);
        }


        int segmentLength = 5;
        double newSquare = function.calculus(bottom);
        double prevSquare;
        double epsilon = 0.01;

        do {
            prevSquare = newSquare;
            newSquare = function.calculus(bottom + segmentLength * prevSquare);
            segmentLength += 5;
        } while (newSquare - prevSquare >= epsilon);

        return (top - bottom) / segmentLength * newSquare;
    }

    public static void main(String[] args) throws FunctionException {
        LinearPolynomial l = new LinearPolynomial(1, 0);
        l.setDomain(3 , 1);

        Integral integral = new Integral(3, 1);
        System.out.println(integral.calculate(l));
    }
}
