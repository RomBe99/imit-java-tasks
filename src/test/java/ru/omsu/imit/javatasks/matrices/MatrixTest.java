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
}
