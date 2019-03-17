package ru.omsu.imit.javatasks.matrices;

import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {
    private Matrix matrix;
    private final double DELTA = 0.0001;

    @Test
    public void calculateDeterminantTestWithZeros1() {
        final double DET = 0;
        final int SIZE = 4;
        final double[] ELEMENTS = new double[]{7, 0, 5, 6,
                8, 0, 9, 4,
                1, 0, 2, 4,
                9, 0, 3, 1};

        try {
            matrix = new Matrix(SIZE, ELEMENTS);
            Assert.assertEquals(DET, matrix.calculateDeterminant(), DELTA);
            Assert.assertArrayEquals(ELEMENTS, matrix.getElements(), DELTA);
        } catch (MatrixException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calculateDeterminantTestWithZeros2() {
        final double DET = 0;
        final int SIZE = 4;
        final double[] ELEMENTS = new double[]{0, 0, 0, 0,
                8, 3, 9, 4,
                1, 2, 2, 4,
                9, 5, 3, 1};

        try {
            matrix = new Matrix(SIZE, ELEMENTS);
            Assert.assertEquals(DET, matrix.calculateDeterminant(), DELTA);
            Assert.assertArrayEquals(ELEMENTS, matrix.getElements(), DELTA);
        } catch (MatrixException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calculateDeterminantTest() {
        final double DET = 620;
        final int SIZE = 4;
        final double[] ELEMENTS = new double[]{7, 3, 5, 6,
                8, 2, 9, 4,
                1, 5, 2, 4,
                9, 0, 3, 1};

        try {
            matrix = new Matrix(SIZE, ELEMENTS);
            Assert.assertEquals(DET, matrix.calculateDeterminant(), DELTA);
            Assert.assertArrayEquals(ELEMENTS, matrix.getElements(), DELTA);
        } catch (MatrixException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixMinorTest() {
        final int ROW = 0;
        final int COLUMN = 1;

        final double[] MINOR_ELEMENTS = new double[]{8, 9, 4,
                1, 2, 4,
                9, 3, 1};

        final int MATRIX_SIZE = 4;
        final double[] MATRIX_ELEMENTS = new double[]{7, 3, 5, 6,
                8, 2, 9, 4,
                1, 5, 2, 4,
                9, 0, 3, 1};

        try {
            matrix = new Matrix(MATRIX_SIZE, MATRIX_ELEMENTS);
            Assert.assertArrayEquals(MINOR_ELEMENTS, matrix.getMinor(ROW, COLUMN).getElements(), DELTA);
        } catch (MatrixException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws MatrixException {
        Matrix m = new Matrix(3, new double[]{1,2,3, 0,0,5, 0, 0, 7});
        Assert.assertEquals(0.0, m.calculateDeterminant(), DELTA);
    }
}
