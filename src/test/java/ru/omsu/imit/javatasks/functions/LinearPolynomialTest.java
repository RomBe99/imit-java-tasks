package ru.omsu.imit.javatasks.functions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LinearPolynomialTest {
    private LinearPolynomial linearPolynomial;

    @Before
    public void setUp() throws Exception {
        linearPolynomial = new LinearPolynomial(1, 2);
    }


    @Test
    public void testLinearPolynomialCalculusCorrect() {
        try {
            double result = linearPolynomial.calculus(2);
            assertEquals(5, (int) result);
        } catch (Exception ex) {
            fail();
        }
    }

//    @Test
//    public void testLinearPolynomialCalculusIncorrect() {
//        try {
//            exhibitor.calculus(20);
//        } catch (FunctionException ex) {
//            throw ex;
//        } catch (Exception ex) {
//            fail();
//        }
//    }
}
