package ru.omsu.imit.javatasks.matrices;

public class InvertibleMatrix implements IInvertibleMatrix {
    private Matrix matrix;

    public InvertibleMatrix(final Matrix matrix) throws MatrixException {
        setMatrix(matrix);
    }

    @Override
    public IInvertibleMatrix reciprocalMatrix() throws MatrixException {
        Matrix tempMatrix = new Matrix(matrix.getRows(), 2 * matrix.getColumns());
        final int ROWS = matrix.getRows();
        final int COLUMNS = tempMatrix.getColumns();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                tempMatrix.setMatrixElem(i, j, matrix.getMatrixElem(i, j));
            }

            tempMatrix.setMatrixElem(i, ROWS + i, 1);
        }

        Matrix reciprocalMatrix = new Matrix(ROWS);

        // TODO Реализовать поиск обратной матрицы

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < ROWS; j++) {
                reciprocalMatrix.setMatrixElem(i, j, tempMatrix.getMatrixElem(i, ROWS + j));
            }
        }

        reciprocalMatrix.calculateDeterminant();

        return new InvertibleMatrix(reciprocalMatrix);
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
        if (matrix.getRows() != matrix.getColumns()) {
            throw new MatrixException("Matrix is not square");
        }

        if (!matrix.isDeterminantIsCorrect() || matrix.getDeterminant() == 0) {
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

    @Override
    public double[] getElements() {
        return matrix.getElements();
    }

    public Matrix getMatrix() {
        return matrix;
    }
}