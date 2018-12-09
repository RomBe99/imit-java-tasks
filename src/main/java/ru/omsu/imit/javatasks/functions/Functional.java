package ru.omsu.imit.javatasks.functions;

public class Functional<T extends IFunction> implements IFunctional<T> {
    private double beginValue;
    private double endValue;
    private T function;

    public Functional(double beginValue, double endValue, T function) {
        setBeginValue(beginValue);
        setEndValue(endValue);
        setFunction(function);
    }

    public double calculateValueInStartpoint() {
        return function.calculus(beginValue);
    }

    public double calculateValueInEndpoint() {
        return function.calculus(endValue);
    }

    public double calculateValueInMidpoint() {
        return (calculateValueInStartpoint() + calculateValueInEndpoint()) / 2;
    }

    public void setBeginValue(double beginValue) {
        this.beginValue = beginValue;
    }

    public void setEndValue(double endValue) {
        this.endValue = endValue;
    }

    public void setFunction(T function) {
        this.function = function;
    }

    public double getBeginValue() {
        return beginValue;
    }

    public double getEndValue() {
        return endValue;
    }

    public T getFunction() {
        return function;
    }

    //TODO Fix this
    @Override
    public int calculusFunctional(T function) {
        return 0;
    }
}
