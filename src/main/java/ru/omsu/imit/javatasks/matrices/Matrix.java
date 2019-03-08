package ru.omsu.imit.javatasks.matrices;

public class Matrix implements IMatrix {
    private int rows;
    private int columns;
    private double[] elements;
    private double determinant;
    private boolean determinantIsCorrect = false;

    private Matrix(final int rows, final int columns) throws MatrixException {
        this(rows, columns, new double[rows * columns]);
    }

    public Matrix(final int rowsAndColumns) throws MatrixException {
        this(rowsAndColumns, rowsAndColumns);
    }

    private Matrix(final int rows, final int columns, final double[] elements) throws MatrixException {
        if (rows * columns != elements.length) {
            throw new MatrixException("Incorrect rows or columns");
        }

        setRows(rows);
        setColumns(columns);
        setElements(elements);
    }

    public Matrix(final int rowsAndColumns, final double[] elements) throws MatrixException {
        this(rowsAndColumns, rowsAndColumns, elements);
    }

    public Matrix(final Matrix matrixForCopy) throws MatrixException {
        setRows(matrixForCopy.rows);
        setColumns(matrixForCopy.columns);
        setElements(matrixForCopy.elements);

        this.determinant = matrixForCopy.determinant;
        this.determinantIsCorrect = matrixForCopy.determinantIsCorrect;
    }

    @Override
    public double calculateDeterminant() throws MatrixException {
        if (determinantIsCorrect) {
            return determinant;
        }

        Matrix matrixCopy = new Matrix(this);
        final int SIZE = matrixCopy.getRows();
        boolean sign = false;
        double temp;
        double temp2;
        int maxIndex = -1;

        determinant = 1;

        for (int i = 0; i < SIZE; i++) {
            temp = matrixCopy.getMatrixElem(i, i);

            if (temp == 0) {
                temp2 = temp;

                for (int j = i; j < SIZE; j++) {
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
        if (elements.length <= i || elements.length <= j) {
            throw new MatrixException("Incorrect index");
        }

        elements[i * columns + j] = value;
        determinantIsCorrect = false;
    }

    @Override
    public double getMatrixElem(final int i, final int j) throws MatrixException {
        if (elements.length <= i || elements.length <= j) {
            throw new MatrixException("Incorrect index");
        }

        return elements[i * columns + j];
    }

    public void setMatrixElem(final int i, final double value) throws MatrixException {
        if (elements.length <= i) {
            throw new MatrixException("Incorrect index");
        }

        elements[i] = value;
        determinantIsCorrect = false;
    }

    private void setRows(final int rows) {
        this.rows = rows;
    }

    private void setColumns(final int columns) {
        this.columns = columns;
    }

    private void setElements(double[] elements) throws MatrixException {
        if (elements == null) {
            throw new MatrixException(new NullPointerException().toString());
        }

        this.elements = elements;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
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

    public boolean isDeterminantIsCorrect() {
        return determinantIsCorrect;
    }
}