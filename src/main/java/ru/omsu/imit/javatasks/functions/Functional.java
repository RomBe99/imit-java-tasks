package ru.omsu.imit.javatasks.functions;

public class Functional<T extends IFunction> implements IFunctional<T> {
    private double beginValue;
    private double endValue;

    public Functional(double beginValue, double endValue) {
        setBeginValue(beginValue);
        setEndValue(endValue);
    }

    public void setBeginValue(double beginValue) {
        this.beginValue = beginValue;
    }

    public void setEndValue(double endValue) {
        this.endValue = endValue;
    }

    public double getBeginValue() {
        return beginValue;
    }

    public double getEndValue() {
        return endValue;
    }

    //TODO Fix this
    @Override
    public double calculate(T function) {
//        [beginValue, endValue]
//         function.
        return 0;
    }
}
