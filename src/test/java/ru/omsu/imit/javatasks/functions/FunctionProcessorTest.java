package ru.omsu.imit.javatasks.functions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionProcessorTest {
    private LinearPolynomial linearPolynomial;
    private final double DELTA = 0.01;

    @Before
    public void setUp() throws FunctionException {
        linearPolynomial = new LinearPolynomial(1, 2);
        linearPolynomial.setDomain(13, -20);
    }

    @Test
    public void testSumValuesAtTheEndsSegment() {
        try {
            double result = FunctionProcessor.sumValuesAtTheEndsSegment(linearPolynomial);
            assertEquals(-12, result, DELTA);
        } catch (FunctionException ex) {
            fail();
        }
    }

    @Test
    public void testSumAtTheMiddleSegment() {
        try {
            double result = FunctionProcessor.sumAtTheMiddleSegment(linearPolynomial);
            assertEquals(-6, result, DELTA);
        } catch (FunctionException ex) {
            fail();
        }
    }
}