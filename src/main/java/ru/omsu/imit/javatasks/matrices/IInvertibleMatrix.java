package ru.omsu.imit.javatasks.matrices;

public interface IInvertibleMatrix extends IMatrix {
    IInvertibleMatrix reciprocalMatrix(final double EPSILON) throws MatrixException ;
}