package ru.omsu.imit.javatasks.matrices;

public class Matrix implements IMatrix {
    private int rows;
    private int columns;
    private double[] elements;
    private double determinant;
    private boolean determinantIsCorrect;

    private Matrix(final int rows, final int columns) {
        setRows(rows);
        setColumns(columns);

        elements = new double[rows * columns];
        determinantIsCorrect = false;
    }

    public Matrix(final int rowsAndColumns) {
        this(rowsAndColumns, rowsAndColumns);
    }

    private Matrix(final int rows, final int columns, final double[] elements) {
        this(rows, columns);

        if (rows * columns != elements.length) {
            // throw TODO Исключение
        }

        setElements(elements);
    }

    public Matrix(final int rowsAndColumns, final double[] elements) {
        this(rowsAndColumns, rowsAndColumns, elements);
    }

    @Override // TODO Вычисление определителя матрицы (методом Гаусса)
    public double calculateDeterminant() {
        if (determinantIsCorrect) {
            return determinant;
        }

        double[] detMatrix = elements;
        final int SIZE = rows;
        double temp;
        determinant = 1;

        for (int i = 0; i < SIZE - 1; i++) {
            temp = detMatrix[i * SIZE - SIZE + i - 1];

            for (int j = i; j < SIZE; j++) {
                detMatrix[(i + 1) * SIZE - SIZE + j - 1] = detMatrix[i * SIZE - SIZE + j - 1] / temp;
            }

            determinant *= temp;
        }

        determinantIsCorrect = true;
        return determinant;
    }

    @Override
    public void setMatrixElem(final int i, final int j, final double value) {
        elements[i * columns - rows + j - 1] = value;
        determinantIsCorrect = false;
    }

    @Override
    public double getMatrixElem(final int i, final int j) {
        return elements[i * columns - rows + j - 1];
    }

    public void setMatrixElem(final int i, final double value) {
        elements[i] = value;
        determinantIsCorrect = false;
    }

    private void setRows(final int rows) {
        this.rows = rows;
    }

    private void setColumns(final int columns) {
        this.columns = columns;
    }

    private void setElements(double[] elements) {
        this.elements = elements;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public double getMatrixElem(final int i) {
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