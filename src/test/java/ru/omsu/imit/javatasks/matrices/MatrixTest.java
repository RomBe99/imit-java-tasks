package ru.omsu.imit.javatasks.matrices;

import org.junit.Before;

import java.io.File;

public class MatrixTest {
    private Matrix matrix;
    private final String PATH = "./src/test/java/ru/omsu/imit/javatasks/matrices/examples/";
    private final File CORRECT_MATIX = new File(PATH + "CorrectMatrix.txt");
    private final File INCORRECT_MATIX = new File(PATH + "IncorrectMatrix.txt");

    @Before
    public void setUp() {
    }

//    public static void main(String[] args) {
//        double[] elems = new double[]{7, 3, 5, 6,
//                8, 2, 9, 4,
//                1, 5, 2, 4,
//                9, 0, 3, 1};
//        Matrix matrix = new Matrix(16, elems);
//        System.out.println(matrix.calculateDeterminant());
//    }
}
