package ru.omsu.imit.javatasks.functions;

public class RationalIFunction extends Function implements IFunction {
    private LinearPolynomial divider;
    private LinearPolynomial dividend;

    public RationalIFunction(LinearPolynomial divider, LinearPolynomial dividend, double top, double bottom) throws FunctionException {
        super(top, bottom);
        setDivider(divider);
        setDividend(dividend);
    }

    public void setDivider(LinearPolynomial divider) {
        if (divider == null) {
            throw new NullPointerException();
        }

        this.divider = divider;
    }

    public void setDividend(LinearPolynomial dividend) {
        if (dividend == null) {
            throw new NullPointerException();
        }


        if (dividend.getFirstCoefficient() == 0 && dividend.getSecondCoefficient() == 0) {
            throw new ArithmeticException("Dividend = 0");
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
