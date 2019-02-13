package ru.omsu.imit.javatasks.matrices;

public class InvertibleMatrix extends Matrix implements  IInvertibleMatrix {
    private InvertibleMatrix(int rows, int columns) {
        super(rows, columns);
    }

    public InvertibleMatrix(int rowsAndColumns) {
        super(rowsAndColumns);
    }

    @Override
    public IInvertibleMatrix reciprocalMatrix() {
        return null;
    }
}