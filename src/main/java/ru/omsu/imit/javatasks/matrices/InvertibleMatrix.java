package ru.omsu.imit.javatasks.matrices;

public class InvertibleMatrix implements IInvertibleMatrix {
    private Matrix matrix;

    public InvertibleMatrix(final Matrix matrix) throws MatrixException {
        setMatrix(matrix);
    }

    @Override
    public InvertibleMatrix reciprocalMatrix() throws MatrixException {
        final int SIZE = matrix.getSize();
        Matrix reciprocalMatrix = new Matrix(SIZE);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                reciprocalMatrix.setMatrixElem(i, j, matrix.getMinor(i, j).calculateDeterminant());
            }
        }

        double temp;

        for (int i = 0; i < SIZE; i++) {
            for (int j = i + 1; j < SIZE - 1; j++) {
                temp = reciprocalMatrix.getMatrixElem(i, j);
                reciprocalMatrix.setMatrixElem(i, j, reciprocalMatrix.getMatrixElem(j, i));
                reciprocalMatrix.setMatrixElem(j, i, temp);
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

    @Override
    public Matrix getMinor(final int i, final int j) throws MatrixException {
        return matrix.getMinor(i, j);
    }

    public void setMatrix(final Matrix matrix) throws MatrixException {
        if (matrix.getSize() != matrix.getSize()) {
            throw new MatrixException("Matrix is not square");
        }

        if (!matrix.isDeterminantIsCorrect() || matrix.getDeterminant() == 0) {
            throw new MatrixException("incorrect determinant");
        }

        this.matrix = matrix;
    }

    public double[] getElements() {
        return matrix.getElements();
    }
}