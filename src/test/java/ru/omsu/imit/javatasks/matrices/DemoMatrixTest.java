package ru.omsu.imit.javatasks.matrices;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DemoMatrixTest {
    private Matrix matrix;

    @Before
    public void setUp() throws MatrixException {
        double[] elements = new double[] {7, 3, 5, 6,
                8, 2, 9, 4,
                1, 5, 2, 4,
                9, 0, 3, 1};

        matrix = new Matrix(4, elements);
    }

    @Test
    public void matrixToTableTest() {
        final boolean result;
        try {
            result = DemoMatrix.matrixToTable(matrix).equals("7.0 3.0 5.0 6.0\n" +
                    "8.0 2.0 9.0 4.0\n" +
                    "1.0 5.0 2.0 4.0\n" +
                    "9.0 0.0 3.0 1.0\n");
            Assert.assertTrue(result);
        } catch (MatrixException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sumAllMatrixElementsTest() {
        try {
            final double RESULT = DemoMatrix.sumAllMatrixElements(matrix);
            final double ELEM_SUM = 69;
            final double DELTA = 0.0001;
            Assert.assertEquals(ELEM_SUM, RESULT, DELTA);
        } catch (MatrixException e) {
            e.printStackTrace();
        }
    }
}
