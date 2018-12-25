package ru.omsu.imit.javatasks.functions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RationalFunctionTest {
    private RationalIFunction rationalIFunction;
    private final double DELTA = 0.01;

    @Before
    public void setUp() throws FunctionException {
        rationalIFunction = new RationalIFunction(new LinearPolynomial(1, 2), new LinearPolynomial(3, 3));
    }

    @Test
    public void testCalculusCorrect() {
        try {
            double result = rationalIFunction.calculus(2);
            assertEquals(5.0 / 9.0, result, DELTA);
        } catch (Exception ex) {
            fail();
        }
    }

    @Test (expected = FunctionException.class)
    public void testDivisionByZero() throws FunctionException {
        try {
            rationalIFunction.calculus(-1);
        } catch (FunctionException ex) {
            throw ex;
        } catch (Exception ex) {
            fail();
        }
    }

    @Test (expected = FunctionException.class)
    public void testZeroDividendInConstructor() throws FunctionException {
        try {
            rationalIFunction.setDividend(new QuadricPolynomial(0, 0, 0));
        } catch (FunctionException ex) {
            throw ex;
        } catch (Exception ex) {
            fail();
        }
    }
}
