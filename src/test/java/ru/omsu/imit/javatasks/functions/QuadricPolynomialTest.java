package ru.omsu.imit.javatasks.functions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuadricPolynomialTest {
    private QuadricPolynomial quadricPolynomial;
    private final double DELTA = 0.01;

    @Before
    public void setUp() throws FunctionException {
        quadricPolynomial = new QuadricPolynomial(1, 0, 3);
    }

    @Test
    public void testCalculusCorrect() {
        try {
            double result = quadricPolynomial.calculus(2);
            assertEquals(13, result, DELTA);
        } catch (Exception ex) {
            fail();
        }
    }
}