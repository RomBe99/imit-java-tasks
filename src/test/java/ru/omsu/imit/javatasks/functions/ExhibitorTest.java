package ru.omsu.imit.javatasks.functions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ExhibitorTest {
    private Exhibitor exhibitor;
    private final double DELTA = 0.01;

    @Before
    public void setUp() throws FunctionException {
        exhibitor = new Exhibitor(new LinearPolynomial(1, 2), 4, 0);
    }

    @Test
    public void testCalculusCorrect() {
        try {
            double result = exhibitor.calculus(2);
            assertEquals(1 + 2 * Math.E * Math.E, result, DELTA);
        } catch (Exception ex) {
            fail();
        }
    }

    @Test (expected = FunctionException.class)
    public void testCalculusIncorrect() throws FunctionException {
        try {
            exhibitor.calculus(20);
        } catch (FunctionException ex) {
            throw ex;
        } catch (Exception ex) {
            fail();
        }
    }
}
