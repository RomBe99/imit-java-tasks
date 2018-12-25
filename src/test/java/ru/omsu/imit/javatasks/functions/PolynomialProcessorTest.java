package ru.omsu.imit.javatasks.functions;

import org.junit.Test;

import static org.junit.Assert.*;

public class PolynomialProcessorTest {
    private QuadricPolynomial quadricPolynomial;
    private final double DELTA = 0.01;

    @Test
    public void testHasDifferentRoots() {
        try {
            quadricPolynomial = new QuadricPolynomial(-4, 3, 1);
            double[] result = PolynomialProcessor.findRoots(quadricPolynomial);
            assertArrayEquals(new double[]{1, -4}, result, DELTA);
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void testHasEqualRoots() {
        try {
            quadricPolynomial = new QuadricPolynomial(1, -2, 1);
            double[] result = PolynomialProcessor.findRoots(quadricPolynomial);
            assertArrayEquals(new double[]{1, 1}, result, DELTA);
        } catch (Exception ex) {
            fail();
        }
    }

    @Test (expected = FunctionException.class)
    public void testHasComplexRoots() throws FunctionException {
        try {
            quadricPolynomial = new QuadricPolynomial(1, 0, 1);
            PolynomialProcessor.findRoots(quadricPolynomial);
        } catch (FunctionException ex) {
            throw ex;
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void maxRootFromDifferentRoots() {
        try {
            quadricPolynomial = new QuadricPolynomial(-4, 3, 1);
            double result = PolynomialProcessor.maxRoot(quadricPolynomial);
            assertEquals(1, result, DELTA);
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void maxRootFromEqualRoots() {
        try {
            quadricPolynomial = new QuadricPolynomial(1, -2, 1);
            double result = PolynomialProcessor.maxRoot(quadricPolynomial);
            assertEquals(1, result, DELTA);
        } catch (Exception ex) {
            fail();
        }
    }
}