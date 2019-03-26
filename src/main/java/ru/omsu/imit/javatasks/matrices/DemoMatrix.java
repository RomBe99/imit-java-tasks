package ru.omsu.imit.javatasks.matrices;

import com.google.gson.Gson;

public class DemoMatrix {
    public static double sumAllMatrixElements(final Matrix matrix) throws MatrixException {
        final int MATRIX_SIZE = matrix.getSize() * matrix.getSize();
        int sum = 0;

        for (int i = 0; i < MATRIX_SIZE; i++) {
            sum += matrix.getMatrixElem(i);
        }

        return sum;
    }

    public static String matrixSurrealization(final Matrix matrix) {
        return new Gson().toJson(matrix);
    }

    public static Matrix matrixDesurrealization(final String gsonMatrix) {
        return new Gson().fromJson(gsonMatrix, Matrix.class);
    }
}