package ru.omsu.imit.javatasks.functions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LinearPolynomialTest {
    private LinearPolynomial linearPolynomial;
    private final double DELTA = 0.01;

    @Before
    public void setUp() throws FunctionException {
        linearPolynomial = new LinearPolynomial(1, 2);
    }


    @Test
    public void testLinearPolynomialCalculusCorrect() {
        try {
            double result = linearPolynomial.calculus(2.5);
            assertEquals(6, result, DELTA);
        } catch (Exception ex) {
            fail();
        }
    }
}
