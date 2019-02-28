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
        if (rows * columns != elements.length) {
            // throw TODO Исключение
        }

        setRows(rows);
        setColumns(columns);
        setElements(elements);

        determinantIsCorrect = false;
    }

    public Matrix(final int rowsAndColumns, final double[] elements) {
        this(rowsAndColumns, rowsAndColumns, elements);
    }

    public Matrix(final Matrix matrixForCopy) {
        setRows(matrixForCopy.rows);
        setColumns(matrixForCopy.columns);
        setElements(matrixForCopy.elements);

        this.determinant = matrixForCopy.determinant;
        this.determinantIsCorrect = matrixForCopy.determinantIsCorrect;
    }

    @Override // TODO Вычисление определителя матрицы (методом Гаусса)
    public double calculateDeterminant() {
        if (determinantIsCorrect) {
            return determinant;
        }

        Matrix matrixCopy = new Matrix(this);
        final double DELTA = 0.00001;
        final int SIZE = matrixCopy.getRows();
        boolean sign = false;
        double temp;
        double temp2;
        determinant = 1;

        for (int i = 0; i < SIZE; i++) {
            temp = matrixCopy.getMatrixElem(i, i);

            // TODO Проверка деления на 0 и перемещение столбцов

            determinant *= (sign ? -temp : temp);

            for (int j = i + 1; j < SIZE; j++) {
                temp2 = matrixCopy.getMatrixElem(j, i);

                for (int k = i; k < SIZE; k++) {
                    matrixCopy.setMatrixElem(j, k, matrixCopy.getMatrixElem(j, k) - matrixCopy.getMatrixElem(i, k) / temp * temp2);
                }
            }
        }

        determinantIsCorrect = true;
        System.out.println(DemoMatrix.matrixToTable(matrixCopy));
        return determinant;
    }

    @Override
    public void setMatrixElem(final int i, final int j, final double value) {
        if (elements.length <= i || elements.length <= j) {
            // throw  TODO Исключение
        }

        elements[i * columns + j] = value;
        determinantIsCorrect = false;
    }

    @Override
    public double getMatrixElem(final int i, final int j) {
        if (elements.length <= i || elements.length <= j) {
            // throw  TODO Исключение
        }

        return elements[i * columns + j];
    }

    public void setMatrixElem(final int i, final double value) {
        if (elements.length <= i) {
            // throw  TODO Исключение
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

    private void setElements(double[] elements) {
        if (elements == null) {
            // throw  TODO Исключение
        }

        this.elements = elements;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public double getMatrixElem(final int i) {
        if (elements.length <= i) {
            // throw  TODO Исключение
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

    public static void main(String[] args) {
        double[] arr =  {7, 3, 5, 6,
                8, 2, 9, 4,
                1, 5, 2, 4,
                9, 0, 3, 1};
        Matrix matrix = new Matrix(4, arr);
        System.out.println(DemoMatrix.matrixToTable(matrix));
        System.out.println(matrix.calculateDeterminant());
    }
}