package ru.omsu.imit.javatasks.reflection;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.omsu.imit.javatasks.collections.Human;
import ru.omsu.imit.javatasks.collections.Student;
import ru.omsu.imit.javatasks.geometry.Point3D;
import ru.omsu.imit.javatasks.geometry.Vector3DProcessor;
import ru.omsu.imit.javatasks.matrices.IMatrix;
import ru.omsu.imit.javatasks.matrices.Matrix;
import ru.omsu.imit.javatasks.payments.Payment;

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
        final int ACTUAL = ReflectionDemo.numberOfPeopleOnList(listForSearch);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] numberPublicClassMethodsTestData() {
        final IMatrix MATRIX_FOR_TEST = Mockito.mock(Matrix.class);
        final Payment PAYMENT_FOR_TEST = Mockito.mock(Payment.class);
        final Point3D POINT3D_FOR_TEST = Mockito.mock(Point3D.class);
        final Vector3DProcessor VECTOR_3D_PROCESSOR_FOR_TEST = Mockito.mock(Vector3DProcessor.class);

        return new Object[][]{
                {MATRIX_FOR_TEST, 15},
                {PAYMENT_FOR_TEST, 15},
                {POINT3D_FOR_TEST, 13},
                {VECTOR_3D_PROCESSOR_FOR_TEST, 5}
        };
    }

    @Test(dataProvider = "numberPublicClassMethodsTestData")
    public void numberPublicClassMethodsTest(final Object o, final int expected) {
        final int ACTUAL = ReflectionDemo.numberPublicClassMethods(o);

        assertEquals(ACTUAL, expected);
    }
}
