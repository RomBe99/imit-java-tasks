package ru.omsu.imit.javatasks.matrices;

public class InvertibleMatrix implements  IInvertibleMatrix {
    private Matrix matrix;

    public InvertibleMatrix(final Matrix matrix) {
        setMatrix(matrix);
    }

    @Override // TODO Реализовать поиск обратной матрицы
    public IInvertibleMatrix reciprocalMatrix() {
        return null;
    }

    @Override
    public double calculateDeterminant() {
        return matrix.calculateDeterminant();
    }

    @Override
    public void setMatrixElem(final int i, final int j, final double value) {
        matrix.setMatrixElem(i, j, value);
    }

    @Override
    public double getMatrixElem(final int i, final int j) {
        return matrix.getMatrixElem(i, j);
    }

    @Override
    public String toString() {
        return matrix.toString();
    }

    public void setMatrix(final Matrix matrix) {
        this.matrix = matrix;
    }

    public Matrix getMatrix() {
        return matrix;
    }
}