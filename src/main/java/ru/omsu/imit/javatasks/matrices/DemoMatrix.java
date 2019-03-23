package ru.omsu.imit.javatasks.matrices;

public class DemoMatrix {
    public static double sumAllMatrixElements(final Matrix matrix) throws MatrixException {
        final int MATRIX_SIZE = matrix.getSize() * matrix.getSize();
        int sum = 0;

        for (int i = 0; i < MATRIX_SIZE; i++) {
            sum += matrix.getMatrixElem(i);
        }

        return sum;
    }
}