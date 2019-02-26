package ru.omsu.imit.javatasks.matrices;

public class DemoMatrix {
    public static double sumAllMatrixElements(final IMatrix matrix) {
        final int MATRIX_SIZE = matrix.getColumns() * matrix.getColumns();
        int sum = 0;

        for (int i = 0; i < MATRIX_SIZE; i++) {
            sum += matrix.getMatrixElem(i);
        }

        return sum;
    }

    public static String matrixToTable(final IMatrix matrix) {
        StringBuilder sb = new StringBuilder();
        final int MATRIX_SIZE = matrix.getRows() * matrix.getRows();
        final int ROWS = matrix.getRows() - 1;

        for (int i = 0; i < MATRIX_SIZE; i++) {
            sb.append(matrix.getMatrixElem(i) + (i % ROWS != 0 ? ' ' : '\n'));
        }

        return sb.toString();
    }
}