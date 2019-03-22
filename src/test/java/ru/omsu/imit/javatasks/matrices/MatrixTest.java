package ru.omsu.imit.javatasks.matrices;

import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {
    private Matrix matrix;
    private final double DELTA = 0.0001;

    @Test
    public void calculateDeterminantTestWithZeros1() throws MatrixException {
        final double DET = 0;
        final int SIZE = 4;
        final double[] ELEMENTS = new double[]{7, 0, 5, 6,
                                               8, 0, 9, 4,
                                               1, 0, 2, 4,
                                               9, 0, 3, 1};

        matrix = new Matrix(SIZE, ELEMENTS);
        Assert.assertEquals(DET, matrix.calculateDeterminant(), DELTA);
    }

    @Test
    public void calculateDeterminantTestWithZeros2() throws MatrixException {
        final double DET = 0;
        final int SIZE = 4;
        final double[] ELEMENTS = new double[]{0, 0, 0, 0,
                                               8, 3, 9, 4,
                                               1, 2, 2, 4,
                                               9, 5, 3, 1};

        matrix = new Matrix(SIZE, ELEMENTS);
        Assert.assertEquals(DET, matrix.calculateDeterminant(), DELTA);
    }

    @Test
    public void calculateDeterminantTestWithZeros3() throws MatrixException {
        final double DET = 0;
        final int SIZE = 3;
        final double[] ELEMENTS = new double[]{1, 2, 3,
                                               0, 0, 5,
                                               0, 0, 7};

        matrix = new Matrix(SIZE, ELEMENTS);
        Assert.assertEquals(DET, matrix.calculateDeterminant(), DELTA);
    }

    @Test
    public void calculateDeterminantTestWithZeros4() throws MatrixException {
        final double DET = 0;
        final int SIZE = 4;
        final double[] ELEMENTS = new double[]{7, 3, 5, 6,
                                               0, 0, 9, 4,
                                               0, 0, 2, 4,
                                               0, 0, 3, 1};

        matrix = new Matrix(SIZE, ELEMENTS);
        Assert.assertEquals(DET, matrix.calculateDeterminant(), DELTA);
    }

    @Test
    public void calculateDeterminantTest() throws MatrixException {
        final double DET = 620;
        final int SIZE = 4;
        final double[] ELEMENTS = new double[]{7, 3, 5, 6,
                                               8, 2, 9, 4,
                                               1, 5, 2, 4,
                                               9, 0, 3, 1};

        matrix = new Matrix(SIZE, ELEMENTS);
        Assert.assertEquals(DET, matrix.calculateDeterminant(), DELTA);
    }

    @Test
    public void matrixMinorTest() throws MatrixException {
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

        matrix = new Matrix(MATRIX_SIZE, MATRIX_ELEMENTS);
        Assert.assertArrayEquals(MINOR_ELEMENTS, matrix.getMinor(ROW, COLUMN).getElements(), DELTA);
    }
}
