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

        final int COLUMNS = matrix.getColumns();
        final int ROWS = matrix.getRows();

        for (int i = 0; i < COLUMNS; i++) {
            for (int j = 0; j < ROWS; j++) {
                sb.append(matrix.getMatrixElem(i, j)).append(j + 1 < ROWS ? " " : "\n");
            }
        }

        return sb.toString();
    }
}