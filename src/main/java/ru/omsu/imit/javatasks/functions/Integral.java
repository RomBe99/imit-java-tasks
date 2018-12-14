package ru.omsu.imit.javatasks.functions;

public class Integral<T extends Function> extends Functional {

    public Integral(double top, double bottom, T function) throws FunctionalException {
        super(top, bottom, function);
    }

    @Override
    public double calculate() throws FunctionException {
        final double top = getTop();
        final double bottom = getBottom();
        final Function function = getFunction();

        double segmentLength;
        double currentValue = 0;
        double previousValue = 0;

        double epsilon = 0.01;
        for (int i = 5; Math.abs(currentValue - previousValue) >= epsilon; i += 5) {
            segmentLength = function.calculus(top) - function.calculus(bottom) / i;
            previousValue = currentValue;
            //todo integral sum
//            currentValue = segmentLength * function.calculus();

//            for (int j = 0; j < 5; j++) {
//
//            }
        }

        return currentValue;
    }
}
