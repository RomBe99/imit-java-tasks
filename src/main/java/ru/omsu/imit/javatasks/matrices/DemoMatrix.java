package ru.omsu.imit.javatasks.matrices;

public class DemoMatrix {
    public static double sumAllMatrixElements(final Matrix matrix) {
        final int MATRIX_SIZE = matrix.getColumns() * matrix.getColumns();
        int sum = 0;

        for (int i = 0; i < MATRIX_SIZE; i++) {
            sum += matrix.getMatrixElem(i);
        }

        return sum;
    }

    public static String matrixToTable(final Matrix matrix) {
        StringBuilder sb = new StringBuilder();
        final int MATRIX_SIZE = matrix.getRows() * matrix.getRows();
        final int ROWS = matrix.getRows() - 1;

        for (int i = 0; i < MATRIX_SIZE; i++) {
            sb.append(matrix.getMatrixElem(i) + (i % ROWS != 0 ? ' ' : '\n'));
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static void main(String[] args) {
    }
}