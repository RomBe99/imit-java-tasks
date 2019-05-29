package ru.omsu.imit.javatasks.matrices;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DemoMatrixTest {
    private Matrix matrix;

    @Before
    public void setUp() throws MatrixException {
        final int SIZE = 4;
        final double[] ELEMENTS = new double[]{7, 3, 5, 6,
                8, 2, 9, 4,
                1, 5, 2, 4,
                9, 0, 3, 1};

        matrix = new Matrix(SIZE, ELEMENTS);
    }

    @Test
    public void sumAllMatrixElementsTest() {
        final double ELEM_SUM = 69;
        final double DELTA = 0.0001;

        try {
            final double RESULT = DemoMatrix.sumAllMatrixElements(matrix);

            Assert.assertEquals(ELEM_SUM, RESULT, DELTA);
        } catch (MatrixException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void matrixSerializeAndDeserializeTest() {
        final Matrix DESERIALIZE_MATRIX = DemoMatrix.matrixDeserialize(DemoMatrix.matrixSerialize(matrix));

        Assert.assertEquals(matrix, DESERIALIZE_MATRIX);
    }
}
