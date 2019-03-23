package ru.omsu.imit.javatasks.matrices;

import java.util.Arrays;
import java.util.Objects;

public class Matrix implements IMatrix {
    private int size;
    private double[] elements;
    private double determinant;
    private boolean determinantIsCorrect = false;

    public Matrix(final int size) throws MatrixException {
        this(size, new double[size * size]);
    }

    public Matrix(final int size, final double[] elements) throws MatrixException {
        if (size * size != elements.length) {
            throw new MatrixException("Incorrect size or columns");
        }

        setSize(size);
        setElements(elements);
    }

    public Matrix(final Matrix matrixForCopy) throws MatrixException {
        setSize(matrixForCopy.size);
        setElements(matrixForCopy.elements);

        this.determinant = matrixForCopy.determinant;
        this.determinantIsCorrect = matrixForCopy.determinantIsCorrect;
    }

    @Override
    public double calculateDeterminant() throws MatrixException {
        if (determinantIsCorrect) {
            return determinant;
        }

        if (size == 1) {
            determinantIsCorrect = true;
            determinant = elements[0];
            return determinant;
        }

        if (size == 2) {
            determinantIsCorrect = true;
            determinant =  elements[0] * elements[3] - (elements[1] * elements[2]);
            return determinant;
        }

        if (size == 3) {
            determinantIsCorrect = true;
            determinant =  elements[0] * elements[4] * elements[8] + elements[1] * elements[5] * elements[6] + elements[2] * elements[3] * elements[7]
                    - (elements[2] * elements[4] * elements[6] + elements[1] * elements[3] * elements[8] + elements[0] * elements[5] * elements[7]);

            return determinant;
        }

        Matrix matrixCopy = new Matrix(this);
        final int SIZE = matrixCopy.getSize();
        boolean sign = false;
        double temp;
        double temp2;
        int maxIndex = -1;

        determinant = 1;

        for (int i = 0; i < SIZE; i++) {
            temp = matrixCopy.getMatrixElem(i, i);

            if (temp == 0) {
                temp2 = temp;

                for (int j = 0; j < SIZE; j++) {
                    if (temp2 >= matrixCopy.getMatrixElem(j, i)) {
                        temp2 = matrixCopy.getMatrixElem(j, i);
                        maxIndex = j;
                        sign = !sign;
                    }
                }

                if (temp2 == 0) {
                    determinantIsCorrect = true;
                    determinant = 0;

                    return 0;
                }

                for (int j = 0; j < SIZE; j++) {
                    temp2 = matrixCopy.getMatrixElem(i, j);
                    matrixCopy.setMatrixElem(i, j, matrixCopy.getMatrixElem(maxIndex, j));
                    matrixCopy.setMatrixElem(maxIndex, j, temp2);
                }
            }

            determinant *= (sign ? -temp : temp);

            for (int j = i + 1; j < SIZE; j++) {
                temp2 = matrixCopy.getMatrixElem(j, i);

                for (int k = i; k < SIZE; k++) {
                    matrixCopy.setMatrixElem(j, k, matrixCopy.getMatrixElem(j, k) - matrixCopy.getMatrixElem(i, k) / temp * temp2);
                }
            }
        }

        determinantIsCorrect = true;
        return determinant;
    }

    @Override
    public void setMatrixElem(final int i, final int j, final double value) throws MatrixException {
        if (size <= i || size <= j) {
            throw new MatrixException("Incorrect index");
        }

        elements[i * size + j] = value;

        if (determinantIsCorrect) {
            determinantIsCorrect = false;
        }
    }

    @Override
    public double getMatrixElem(final int i, final int j) throws MatrixException {
        if (elements.length <= i || elements.length <= j) {
            throw new MatrixException("Incorrect index");
        }

        return elements[i * size + j];
    }

    public void setMatrixElem(final int i, final double value) throws MatrixException {
        if (elements.length <= i) {
            throw new MatrixException("Incorrect index");
        }

        elements[i] = value;

        if (determinantIsCorrect) {
            determinantIsCorrect = false;
        }
    }

    private void setSize(final int size) {
        this.size = size;
    }

    private void setElements(double[] elements) throws MatrixException {
        if (elements == null) {
            throw new MatrixException(new NullPointerException().toString());
        }

        this.elements = elements.clone();
    }

    public int getSize() {
        return size;
    }

    public double getMatrixElem(final int i) throws MatrixException {
        if (elements.length <= i) {
            throw new MatrixException("Incorrect index");
        }

        return elements[i];
    }

    public double[] getElements() {
        return elements;
    }

    public double getDeterminant() {
        return determinant;
    }

    @Override
    public Matrix getMinor(final int i, final int j) throws MatrixException {
        final int SIZE = size;
        boolean overI = false;
        boolean overJ = false;
        Matrix minor = new Matrix(SIZE - 1);

        for (int k = 0; k < SIZE; k++) {
            if (k == i) {
                overI = true;
                continue;
            }

            for (int l = 0; l < SIZE; l++) {
                if (l == j) {
                    overJ = true;
                    continue;
                }

                minor.setMatrixElem((overI ? k - 1 : k), (overJ ? l - 1 : l), this.getMatrixElem(k, l));
            }

            overJ = false;
        }

        return minor;
    }

    public boolean isDeterminantIsCorrect() {
        return determinantIsCorrect;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                try {
                    sb.append(this.getMatrixElem(i, j)).append(j + 1 < size ? " " : "\n");
                } catch (MatrixException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return size == matrix.size && Arrays.equals(elements, matrix.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }
}