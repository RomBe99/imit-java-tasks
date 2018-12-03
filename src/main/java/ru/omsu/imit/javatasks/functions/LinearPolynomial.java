package ru.omsu.imit.javatasks.functions;

public class LinearPolynomial implements Function {
    private double firstCoefficient;
    private double secondCoefficient;

    public LinearPolynomial(double firstCoefficient, double secondCoefficient) {
        setFirstCoefficient(firstCoefficient);
        setSecondCoefficient(secondCoefficient);
    }

    public void setFirstCoefficient(double firstCoefficient) {
        this.firstCoefficient = firstCoefficient;
    }

    public void setSecondCoefficient(double secondCoefficient) {
        this.secondCoefficient = secondCoefficient;
    }

    public double getFirstCoefficient() {
        return firstCoefficient;
    }

    public double getSecondCoefficient() {
        return secondCoefficient;
    }

    @Override
    public double calculus(double value) {
        return firstCoefficient*value + secondCoefficient;
    }
}
