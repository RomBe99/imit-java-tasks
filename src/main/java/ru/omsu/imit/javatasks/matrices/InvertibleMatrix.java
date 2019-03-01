package ru.omsu.imit.javatasks.matrices;

public class InvertibleMatrix implements IInvertibleMatrix {
    private Matrix matrix;

    public InvertibleMatrix(final Matrix matrix) throws MatrixException {
        setMatrix(matrix);
    }

    @Override // TODO Реализовать поиск обратной матрицы
    public IInvertibleMatrix reciprocalMatrix() {
        return null;
    }

    @Override
    public double calculateDeterminant() throws MatrixException {
        return matrix.calculateDeterminant();
    }

    @Override
    public void setMatrixElem(final int i, final int j, final double value) throws MatrixException {
        matrix.setMatrixElem(i, j, value);
    }

    @Override
    public double getMatrixElem(final int i, final int j) throws MatrixException {
        return matrix.getMatrixElem(i, j);
    }

    public void setMatrix(final Matrix matrix) throws MatrixException {
        if (!matrix.isDeterminantIsCorrect() || matrix.getDeterminant() != 0) {
            throw new MatrixException("incorrect determinant");
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
    public double getMatrixElem(final int i) throws MatrixException {
        return matrix.getMatrixElem(i);
    }

    public Matrix getMatrix() {
        return matrix;
    }
}