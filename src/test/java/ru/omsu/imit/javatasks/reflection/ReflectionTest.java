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
import ru.omsu.imit.javatasks.payments.Payment;

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
    public Object[][] numberPublicClassMethodsTestData() {
        final List<String> EXPECTED_LIST_FOR_MATRIX = new ArrayList<>(Arrays.asList(
                "calculateDeterminant", "setMatrixElem", "setMatrixElem", "getMatrixElem", "getMatrixElem", "getElements",
                "getDeterminant", "getMinor", "isDeterminantIsCorrect", "equals", "toString", "hashCode", "getSize"));

        final List<String> EXPECTED_LIST_FOR_PAYMENT = new ArrayList<>(Arrays.asList(
                "getYear", "setFullName", "setDay", "setMonth", "setYear", "setAmountOfPayment", "getFullName", "getDay",
                "getMonth", "getAmountOfPayment", "equals", "toString", "hashCode"));

        final List<String> EXPECTED_LIST_FOR_POINT3D = new ArrayList<>(Arrays.asList(
                "printPoint", "multiplyByNumber", "setX", "setY", "setZ", "getX", "getY", "getZ", "equals", "hashCode"));

        final List<String> EXPECTED_LIST_FOR_VECTOR_3D_PROCESSOR = new ArrayList<>(Arrays.asList(
                "vectorsSum", "vectorsDifference", "dotProduct", "productOfVectors", "vectorsCollinearity", "linearCombinationOfVectors"));


        return new Object[][]{
                {Mockito.mock(Matrix.class), EXPECTED_LIST_FOR_MATRIX},
                {Mockito.mock(Payment.class), EXPECTED_LIST_FOR_PAYMENT},
                {Mockito.mock(Point3D.class), EXPECTED_LIST_FOR_POINT3D},
                {Mockito.mock(Vector3DProcessor.class), EXPECTED_LIST_FOR_VECTOR_3D_PROCESSOR}
        };
    }

    @Test(dataProvider = "numberPublicClassMethodsTestData")
    public void numberPublicClassMethodsTest(final Object objectForTest, final List<String> expected) {
        final List<String> ACTUAL = ReflectionDemo.getListNamesPublicClassMethods(objectForTest);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] objectSuperclassListTestData() {
        final List<String> MATRIX_FOR_TEST_EXPECTED_LIST = new ArrayList<>();
        MATRIX_FOR_TEST_EXPECTED_LIST.add("class ru.omsu.imit.javatasks.matrices.Matrix");
        MATRIX_FOR_TEST_EXPECTED_LIST.add("class java.lang.Object");

        final List<String> DOS_FOR_TEST_EXPECTED_LIST = new ArrayList<>();
        DOS_FOR_TEST_EXPECTED_LIST.add("class java.io.DataOutputStream");
        DOS_FOR_TEST_EXPECTED_LIST.add("class java.io.FilterOutputStream");
        DOS_FOR_TEST_EXPECTED_LIST.add("class java.io.OutputStream");
        DOS_FOR_TEST_EXPECTED_LIST.add("class java.lang.Object");

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

    @DataProvider
    public Object[][] objectGettersAndSettersTestData() throws MatrixException {
        final List<String> MATRIX_FOR_TEST_EXPECTED_LIST = new ArrayList<>(
                Arrays.asList("getFullName", "getYear", "setDay", "setMonth", "setYear", "setAmountOfPayment",
                        "setFullName", "getDay", "getMonth", "getAmountOfPayment")
        );

        return new Object[][]{
                {new ReflectionDemo(), new ArrayList<String>()},
                {new Payment(new Payment("", (byte)1, (byte)1, 2000, 1)), MATRIX_FOR_TEST_EXPECTED_LIST}
        };
    }

    public static void main(String[] args) throws MatrixException {
        ReflectionDemo.objectGettersAndSetters(new Payment("", (byte)1, (byte)1, 2000, 1)).forEach(System.out::println);
    }

    @Test(dataProvider = "objectGettersAndSettersTestData")
    public void objectGettersAndSettersTest(final Object objectForTest, final List<String> expectedList) {
        final List<String> ACTUAL = ReflectionDemo.objectGettersAndSetters(objectForTest);

        assertEquals(ACTUAL, expectedList);
    }
}