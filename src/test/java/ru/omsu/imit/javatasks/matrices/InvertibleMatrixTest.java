package ru.omsu.imit.javatasks.matrices;

import org.junit.Assert;
import org.junit.Test;

import static org.testng.Assert.fail;

public class InvertibleMatrixTest {
    private InvertibleMatrix invertibleMatrix;

    @Test(expected = MatrixException.class)
    public void constructorWithZeroDeterminantMatrixTest() throws MatrixException {
        final int SIZE = 4;
        final double[] ELEMENTS = new double[]{7, 0, 5, 6,
                                               8, 0, 9, 4,
                                               1, 0, 2, 4,
                                               9, 0, 3, 1};

        try {
            invertibleMatrix = new InvertibleMatrix(new Matrix(SIZE, ELEMENTS));
        } catch (MatrixException e) {
            throw e;
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void reciprocalMatrixTest1() throws MatrixException {
        final int SIZE = 2;
        final double[] ELEMENTS = new double[]{1, 0,
                                               0, 1};

        final Matrix tempMatrix = new Matrix(SIZE, ELEMENTS);
        tempMatrix.calculateDeterminant();

        invertibleMatrix = new InvertibleMatrix(tempMatrix);
        InvertibleMatrix inverted  = (InvertibleMatrix) invertibleMatrix.reciprocalMatrix();
        InvertibleMatrix iinverted  = (InvertibleMatrix) inverted.reciprocalMatrix();

        Assert.assertEquals(invertibleMatrix, iinverted);
    }

    @Test
    public void reciprocalMatrixTest2() throws MatrixException {
        final int SIZE = 3;
        final double[] ELEMENTS = new double[]{2, 5, 7,
                                               6, 3, 4,
                                               5, -2, -3};

        final Matrix tempMatrix = new Matrix(SIZE, ELEMENTS);
        tempMatrix.calculateDeterminant();

        invertibleMatrix = new InvertibleMatrix(tempMatrix);
        InvertibleMatrix inverted  = (InvertibleMatrix) invertibleMatrix.reciprocalMatrix();
        InvertibleMatrix iinverted  = (InvertibleMatrix) inverted.reciprocalMatrix();

        Assert.assertEquals(invertibleMatrix, iinverted);
    }
}
