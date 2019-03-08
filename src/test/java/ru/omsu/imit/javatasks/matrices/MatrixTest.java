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
        final double[] elements = new double[]{7, 0, 5, 6,
                8, 0, 9, 4,
                1, 0, 2, 4,
                9, 0, 3, 1};

        try {
            matrix = new Matrix(SIZE, elements);
            Assert.assertEquals(DET, matrix.calculateDeterminant(), DELTA);
        } catch (MatrixException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calculateDeterminantTestWithZeros2() {
        final double DET = 0;
        final int SIZE = 4;
        final double[] elements = new double[]{0, 0, 0, 0,
                8, 3, 9, 4,
                1, 2, 2, 4,
                9, 5, 3, 1};

        try {
            matrix = new Matrix(SIZE, elements);
            Assert.assertEquals(DET, matrix.calculateDeterminant(), DELTA);
        } catch (MatrixException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calculateDeterminantTest() {
        final double DET = 620;
        final int SIZE = 4;
        final double[] elements = new double[]{7, 3, 5, 6,
                8, 2, 9, 4,
                1, 5, 2, 4,
                9, 0, 3, 1};

        try {
            matrix = new Matrix(SIZE, elements);
            Assert.assertEquals(DET, matrix.calculateDeterminant(), DELTA);
        } catch (MatrixException e) {
            e.printStackTrace();
        }
    }
}
