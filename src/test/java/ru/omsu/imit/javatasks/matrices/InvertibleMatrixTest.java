package ru.omsu.imit.javatasks.matrices;

import org.junit.Ignore;
import org.junit.Test;

import static org.testng.Assert.fail;

public class InvertibleMatrixTest {
    private InvertibleMatrix matrix;

    @Test (expected = MatrixException.class)
    public void constructorWithZeroDeterminantMatrixTest() throws MatrixException {
        final int SIZE = 4;
        final double[] ELEMENTS = new double[]{7, 0, 5, 6,
                8, 0, 9, 4,
                1, 0, 2, 4,
                9, 0, 3, 1};

        try {
            matrix = new InvertibleMatrix(new Matrix(SIZE, ELEMENTS));
        } catch (MatrixException e) {
            throw e;
        } catch (Exception e) {
            fail();
        }
    }

    @Ignore
    public void reciprocalMatrixTest() {
        final int SIZE = 1;
        final double[] ELEMENTS = new double[]{1};

        try {
            matrix = new InvertibleMatrix(new Matrix(SIZE, ELEMENTS));
        } catch (MatrixException e) {
            e.printStackTrace();
        }
    }
}
