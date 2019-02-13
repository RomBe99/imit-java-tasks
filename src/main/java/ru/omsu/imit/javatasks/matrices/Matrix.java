package ru.omsu.imit.javatasks.matrices;

import java.util.Arrays;
import java.util.Objects;

public class Matrix implements IMatrix {
    private int rows;
    private int columns;
    private double[] elements;

    private Matrix(int rows, int columns) {
        setRows(rows);
        setColumns(columns);

        elements = new double[this.rows * this.columns];
    }

    public Matrix(int rowsAndColumns) {
        this(rowsAndColumns, rowsAndColumns);
    }

    @Override // TODO Вычисление определителя матрицы (методом Гаусса)
    public double determinant() {
        return 0;
    }

    @Override
    public void setMatrixElem(int i, int j, double value) {
        elements[i * columns - rows + j - 1] = value;
    }

    @Override
    public double getMatrixElem(int i, int j) {
        return elements[i * columns - rows + j - 1];
    }

    private void setRows(int rows) {
        this.rows = rows;
    }

    private void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public double[] getElements() {
        return elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return rows == matrix.rows &&
                columns == matrix.columns &&
                Arrays.equals(elements, matrix.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, columns);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }
}