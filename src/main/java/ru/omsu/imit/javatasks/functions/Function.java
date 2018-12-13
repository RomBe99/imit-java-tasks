package ru.omsu.imit.javatasks.functions;

import java.util.Objects;

public abstract class Function implements IFunction {
    private double top;
    private double bottom;

    public Function(double top, double bottom) throws FunctionException {
        setTop(top);
        setBottom(bottom);
    }

    private void setTop(double top) {
        this.top = top;
    }

    private void setBottom(double bottom) throws FunctionException {
        if (top < bottom) {
            throw new FunctionException(bottom);
        }

        this.bottom = bottom;
    }

    public double getTop() {
        return top;
    }

    public double getBottom() {
        return bottom;
    }
}
