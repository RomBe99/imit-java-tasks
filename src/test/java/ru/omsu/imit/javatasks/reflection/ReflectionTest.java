package ru.omsu.imit.javatasks.reflection;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.omsu.imit.javatasks.collections.Human;
import ru.omsu.imit.javatasks.collections.Student;
import ru.omsu.imit.javatasks.geometry.Point3D;
import ru.omsu.imit.javatasks.geometry.Vector3DProcessor;
import ru.omsu.imit.javatasks.matrices.Matrix;
import ru.omsu.imit.javatasks.matrices.MatrixException;
import ru.omsu.imit.javatasks.payments.StringProcessor;

import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionTest extends Assert {

    @DataProvider
    public Object[][] numberOfPeopleOnListTestData() {
        final Human HUMAN_FOR_TEST = new Human("Test", "Test", "Test", 20);
        final Student STUDENT_FOR_TEST = new Student("Test", "Test", "Test", 20, "Test");

        final Object[] OBJECTS = {"", null, STUDENT_FOR_TEST, HUMAN_FOR_TEST, STUDENT_FOR_TEST};
        final Human[] HUMANS = {HUMAN_FOR_TEST, HUMAN_FOR_TEST, HUMAN_FOR_TEST, HUMAN_FOR_TEST, HUMAN_FOR_TEST, HUMAN_FOR_TEST};
        final Student[] STUDENTS = {STUDENT_FOR_TEST, STUDENT_FOR_TEST, STUDENT_FOR_TEST, STUDENT_FOR_TEST, STUDENT_FOR_TEST, STUDENT_FOR_TEST, STUDENT_FOR_TEST, STUDENT_FOR_TEST};
        final Human[] HUMANS_AND_STUDENTS = {STUDENT_FOR_TEST, HUMAN_FOR_TEST, STUDENT_FOR_TEST, STUDENT_FOR_TEST, HUMAN_FOR_TEST, HUMAN_FOR_TEST, STUDENT_FOR_TEST};


        return new Object[][]{
                {new ArrayList<>(Arrays.asList(OBJECTS)), 3},
                {new ArrayList<>(Arrays.asList(HUMANS)), HUMANS.length},
                {new ArrayList<>(Arrays.asList(STUDENTS)), STUDENTS.length},
                {new ArrayList<>(Arrays.asList(HUMANS_AND_STUDENTS)), HUMANS_AND_STUDENTS.length}
        };
    }

    @Test(dataProvider = "numberOfPeopleOnListTestData")
    public void numberOfPeopleOnListTest(final List<?> listForSearch, final int expected) {
        final long ACTUAL = ReflectionDemo.numberOfPeopleOnList(listForSearch);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] numberPublicClassMethodsTestData() throws MatrixException {
        final List<String> EXPECTED_LIST_FOR_MATRIX = new ArrayList<>(Arrays.asList(
                "calculateDeterminant", "setMatrixElem", "setMatrixElem", "getMatrixElem", "getMatrixElem", "getElements",
                "getDeterminant", "getMinor", "isDeterminantIsCorrect", "equals", "toString", "hashCode", "getSize"));

        final List<String> STRING_PROCESSOR_FOR_PAYMENT = new ArrayList<>(Arrays.asList(
                "numberOfEnteriesToString", "replaceNumbersToWords", "stringMultiplier", "removeEverySecondChar"));

        final List<String> EXPECTED_LIST_FOR_POINT3D = new ArrayList<>(Arrays.asList(
                "printPoint", "multiplyByNumber", "setX", "setY", "setZ", "getX", "getY", "getZ", "equals", "hashCode"));

        final List<String> EXPECTED_LIST_FOR_VECTOR_3D_PROCESSOR = new ArrayList<>(Arrays.asList(
                "vectorsSum", "vectorsDifference", "dotProduct", "productOfVectors", "vectorsCollinearity", "linearCombinationOfVectors"));


        return new Object[][]{
                {new Matrix(1), EXPECTED_LIST_FOR_MATRIX},
                {new StringProcessor(), STRING_PROCESSOR_FOR_PAYMENT},
                {new Point3D(), EXPECTED_LIST_FOR_POINT3D},
                {new Vector3DProcessor(), EXPECTED_LIST_FOR_VECTOR_3D_PROCESSOR}
        };
    }

    @Test(dataProvider = "numberPublicClassMethodsTestData")
    public void numberPublicClassMethodsTest(final Object objectForTest, final List<String> expected) {
        final List<String> ACTUAL = ReflectionDemo.getListNamesPublicClassMethods(objectForTest);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] objectSuperclassListTestData() {
        final List<String> MATRIX_FOR_TEST_EXPECTED_LIST = new ArrayList<>(Arrays.asList(
                "class ru.omsu.imit.javatasks.matrices.Matrix", "class java.lang.Object"));

        final List<String> DOS_FOR_TEST_EXPECTED_LIST = new ArrayList<>(Arrays.asList(
                "class java.io.DataOutputStream", "class java.io.FilterOutputStream", "class java.io.OutputStream", "class java.lang.Object"));

        return new Object[][]{
                {Mockito.mock(Matrix.class), MATRIX_FOR_TEST_EXPECTED_LIST},
                {Mockito.mock(DataOutputStream.class), DOS_FOR_TEST_EXPECTED_LIST},
                {new Object(), new ArrayList<String>()}
        };
    }

    @Test(dataProvider = "objectSuperclassListTestData")
    public void objectSuperclassListTest(final Object objectForTest, final List<String> expectedList) {
        final List<String> ACTUAL = ReflectionDemo.objectSuperclassList(objectForTest);

        assertEquals(ACTUAL, expectedList);
    }
}