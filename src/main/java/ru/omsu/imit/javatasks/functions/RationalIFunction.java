package ru.omsu.imit.javatasks.functions;

public class RationalIFunction extends Function implements IFunction {
    private LinearPolynomial divider;
    private LinearPolynomial dividend;

    public RationalIFunction(LinearPolynomial divider, LinearPolynomial dividend) throws FunctionException {
        super(Double.MAX_VALUE, Double.MIN_VALUE);
        setDivider(divider);
        setDividend(dividend);
    }

    public void setDivider(LinearPolynomial divider) {
        if (divider == null) {
            throw new NullPointerException();
        }

        this.divider = divider;
    }

    public void setDividend(LinearPolynomial dividend) throws FunctionException {
        if (dividend == null) {
            throw new NullPointerException();
        }

        if (dividend.getFirstCoefficient() == 0 && dividend.getSecondCoefficient() == 0) {
            throw new FunctionException("The dividend cannot be 0");
        }

        this.dividend = dividend;
    }

    public LinearPolynomial getDivider() {
        return divider;
    }

    public LinearPolynomial getDividend() {
        return dividend;
    }

    @Override
    public double calculus(double value) throws FunctionException {
        return divider.calculus(value) / dividend.calculus(value);
    }
}
