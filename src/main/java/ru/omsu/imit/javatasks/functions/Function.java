package ru.omsu.imit.javatasks.functions;

import java.util.Objects;

public abstract class Function implements IFunction {
    private double top;
    private double bottom;

    public Function(double top, double bottom) {
        setTop(top);
        setBottom(bottom);
    }

    public void setTop(double top) {
        this.top = top;
    }

    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    public double getTop() {
        return top;
    }

    public double getBottom() {
        return bottom;
    }
}
