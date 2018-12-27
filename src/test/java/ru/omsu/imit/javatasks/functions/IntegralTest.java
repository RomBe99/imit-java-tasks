package ru.omsu.imit.javatasks.functions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegralTest {
    private Integral integral;
    private final double DELTA = 0.01;

    @Before
    public void setUp() throws FunctionalException {
        integral = new Integral(4, 0);
    }

    @Test
    public void testCalculusCorrect() throws Exception {
        try {
            LinearPolynomial linearPolynomial = new LinearPolynomial(1, 2);
            double result = integral.calculate(linearPolynomial);
            assertEquals(20, result, DELTA);
        } catch (Exception ex) {
            fail();
        }
    }

    @Test (expected = FunctionalException.class)
    public void testCalculusIncorrect() throws FunctionalException {
        try {
            LinearPolynomial linearPolynomial = new LinearPolynomial(1, 2);
            linearPolynomial.setDomain(3, 1);
            integral.calculate(linearPolynomial);
        } catch (FunctionalException ex) {
            throw ex;
        } catch (Exception ex) {
            fail();
        }
    }
}