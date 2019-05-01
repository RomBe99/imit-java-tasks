package ru.omsu.imit.javatasks.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindNamesakesFromListTest {
    private final String TEST_NAME = "Ivan";
    private final String TEST_PATRONYMIC = "Ivanovich";
    private final int TEST_AGE = 20;
    private final List<Human> HUMANS = new ArrayList<>(Arrays.asList(
            new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
            new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
            new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
            new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
            new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
            new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)));

    @Test
    public void findNamesakesFromListTest0() {
        final Human NAMESAKE = new Human("Vsileev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final List<Human> ACTUAL = CollectionsDemo.findNamesakesFromList(new ArrayList<Human>(), NAMESAKE);

        Assert.assertNull(ACTUAL);
    }

    @Test
    public void findNamesakesFromListTest1() {
        final Human NAMESAKE = new Human("Vsileev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final List<Human> EXPECTED = new ArrayList<>();
        final int EXPECTED_LIST_SIZE = EXPECTED.size();

        final List<Human> ACTUAL = CollectionsDemo.findNamesakesFromList(HUMANS, NAMESAKE);

        assert ACTUAL != null;
        final int ACTUAL_LIST_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_LIST_SIZE, ACTUAL_LIST_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void findNamesakesFromListTest2() {
        final Human NAMESAKE = new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final Human[] HUMANS_EXPECTED = {new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final List<Human> EXPECTED = new ArrayList<>(Arrays.asList(HUMANS_EXPECTED));
        final int EXPECTED_LIST_SIZE = EXPECTED.size();

        final List<Human> ACTUAL = CollectionsDemo.findNamesakesFromList(HUMANS, NAMESAKE);

        assert ACTUAL != null;
        final int ACTUAL_LIST_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_LIST_SIZE, ACTUAL_LIST_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void findNamesakesFromListTest3() {
        final Human NAMESAKE = new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final Human[] HUMANS_EXPECTED = {new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final List<Human> EXPECTED = new ArrayList<>(Arrays.asList(HUMANS_EXPECTED));
        final int EXPECTED_LIST_SIZE = EXPECTED.size();

        final List<Human> ACTUAL = CollectionsDemo.findNamesakesFromList(HUMANS, NAMESAKE);

        assert ACTUAL != null;
        final int ACTUAL_LIST_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_LIST_SIZE, ACTUAL_LIST_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void findNamesakesFromListTest4() {
        final Human NAMESAKE = new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final Human[] HUMANS_EXPECTED = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final List<Human> EXPECTED = new ArrayList<>(Arrays.asList(HUMANS_EXPECTED));
        final int EXPECTED_LIST_SIZE = EXPECTED.size();

        final List<Human> ACTUAL = CollectionsDemo.findNamesakesFromList(HUMANS, NAMESAKE);

        assert ACTUAL != null;
        final int ACTUAL_LIST_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_LIST_SIZE, ACTUAL_LIST_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void findNamesakesFromListTest5() {
        final Human NAMESAKE = new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final Human[] HUMANS_EXPECTED = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final List<Human> EXPECTED = new ArrayList<>(Arrays.asList(HUMANS_EXPECTED));
        final int EXPECTED_LIST_SIZE = EXPECTED.size();

        final List<Human> ACTUAL = CollectionsDemo.findNamesakesFromList(HUMANS, NAMESAKE);

        assert ACTUAL != null;
        final int ACTUAL_LIST_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_LIST_SIZE, ACTUAL_LIST_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }
}