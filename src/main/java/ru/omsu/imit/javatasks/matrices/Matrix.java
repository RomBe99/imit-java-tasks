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

        double[] detMatrix = elements;
        final int SIZE = rows;
        final double DELTA = 0.00001;
        double temp;
        int index = 0;
        int address;
        int address2;
        determinant = 1;

        for (int i = 0; i < SIZE - 1; i++) {
            temp = detMatrix[i * columns - i];

            for (int j = 0; j < SIZE; j++) {
                if (temp <= detMatrix[i * SIZE - i + j]) {
                    temp = detMatrix[i * SIZE - i + j];
                    index = j;
                }
            }

            if (temp <= DELTA && temp >= 0) {
                return 0;
            }

            determinant *= temp;
            address2 = (i + 1) * SIZE - (i + 1) + index - 1;

            for (int j = 0; j < SIZE; j++) {
                address = (i + 1) * SIZE - (i + 1) + j + 1; // Следующая строка
                detMatrix[address] = detMatrix[i * SIZE - i + j] / detMatrix[i * SIZE - i + index] * detMatrix[address2] - detMatrix[address];
            }
        }

        determinantIsCorrect = true;
        return determinant;
    }

    @Override
    public void setMatrixElem(final int i, final int j, final double value) {
        elements[i * columns - i + j] = value;
        determinantIsCorrect = false;
    }

    @Override
    public double getMatrixElem(final int i, final int j) {
        return elements[i * columns - i + j];
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

    public static void main(String[] args) {
        double[] arr =  {7, 3, 5, 6,
                8, 2, 9, 4,
                1, 0, 2, 4,
                9, 5, 3, 1};
        Matrix matrix = new Matrix(4, arr);
        System.out.println(matrix.calculateDeterminant());
    }
}