package ru.omsu.imit.javatasks.matrices;

public interface IMatrix {
    double 	determinant();
    void setMatrixElem(final int i, final int j, final double value);
    double getMatrixElem(final int i, final int j);
}
