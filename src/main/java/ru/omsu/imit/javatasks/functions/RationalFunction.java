package ru.omsu.imit.javatasks.functions;

public class RationalFunction implements Function {
    private LinearPolynomial divider;
    private LinearPolynomial dividend;

    public RationalFunction(LinearPolynomial divider, LinearPolynomial dividend) {
        setDivider(divider);
        setDividend(dividend);
    }

    public RationalFunction(double dividerFirstCoefficient, double dividerSecondCoefficient, double dividendFirstCoefficient, double dividendSecondCoefficient) {
        this(new LinearPolynomial(dividerFirstCoefficient, dividerSecondCoefficient), new LinearPolynomial(dividendFirstCoefficient, dividendSecondCoefficient));
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
    public double calculus(double value) {
        return divider.calculus(value) / dividend.calculus(value);
    }
}
