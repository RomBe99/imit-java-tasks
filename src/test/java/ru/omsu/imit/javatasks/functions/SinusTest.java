package ru.omsu.imit.javatasks.functions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SinusTest {
    private Sinus sinus;
    private final double DELTA = 0.01;

    @Before
    public void setUp() throws FunctionException {
        sinus = new Sinus(new LinearPolynomial(2, 2), 2, -2);
    }

    @Test
    public void testCalculusCorrect() {
        try {
            double result = sinus.calculus(2);
            assertEquals(sinus.getCoefficients().getSecondCoefficient() * Math.sin(sinus.getCoefficients().getFirstCoefficient() * 2), result, DELTA);
        } catch (Exception ex) {
            fail();
        }
    }

    @Test (expected = FunctionException.class)
    public void testCalculusIncorrect() throws FunctionException {
        try {
            sinus.calculus(20);
        } catch (FunctionException ex) {
            throw ex;
        } catch (Exception ex) {
            fail();
        }
    }
}
