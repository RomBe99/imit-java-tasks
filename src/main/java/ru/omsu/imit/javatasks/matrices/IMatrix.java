package ru.omsu.imit.javatasks.matrices;

public interface IMatrix {
    double calculateDeterminant() throws MatrixException;
    void setMatrixElem(final int i, final int j, final double value) throws MatrixException;
    double getMatrixElem(final int i, final int j) throws MatrixException;
    double getMatrixElem(final int i) throws MatrixException;
    int getRows();
    int getColumns();
    IMatrix getMinor(final int i, final int j);
}