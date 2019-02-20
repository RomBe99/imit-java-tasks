package ru.omsu.imit.javatasks.matrices;

public class InvertibleMatrix implements IInvertibleMatrix {
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

    public void setMatrix(final Matrix matrix) {
        if (!matrix.isDeterminantIsCorrect() || matrix.getDeterminant() != 0) {
            // throw TODO Исключение
        }

        this.matrix = matrix;
    }

    @Override
    public int getRows() {
        return matrix.getRows();
    }

    @Override
    public int getColumns() {
        return matrix.getColumns();
    }

    @Override
    public double getMatrixElem(final int i) {
        return matrix.getMatrixElem(i);
    }

    public Matrix getMatrix() {
        return matrix;
    }
}