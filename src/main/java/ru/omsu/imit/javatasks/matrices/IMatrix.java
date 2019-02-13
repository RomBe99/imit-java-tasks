package ru.omsu.imit.javatasks.matrices;

public interface IMatrix {
    double 	determinant();
    void setMatrixElem(int i, int j, double value);
    double getMatrixElem(int i, int j);
}
