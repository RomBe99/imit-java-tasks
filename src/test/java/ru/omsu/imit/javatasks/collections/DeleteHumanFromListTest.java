package ru.omsu.imit.javatasks.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteHumanFromListTest {
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
    public void deleteHumanFromListTest0() {
        final Human HUMAN_FOR_DELETE = new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final List<Human> ACTUAL = CollectionsDemo.deleteHumanFromList(new ArrayList<Human>(), HUMAN_FOR_DELETE);

        Assert.assertNull(ACTUAL);
    }

    @Test
    public void deleteHumanFromListTest1() {
        final Human HUMAN_FOR_DELETE = new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final Human[] HUMANS_EXCEPTED = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final List<Human> EXCEPTED = new ArrayList<>(Arrays.asList(HUMANS_EXCEPTED));
        final int EXCEPTED_LIST_SIZE = EXCEPTED.size();

        final List<Human> ACTUAL = CollectionsDemo.deleteHumanFromList(HUMANS, HUMAN_FOR_DELETE);

        assert ACTUAL != null;
        final int ACTUAL_LIST_SIZE = ACTUAL.size();

        Assert.assertEquals(EXCEPTED_LIST_SIZE, ACTUAL_LIST_SIZE);
        Assert.assertEquals(EXCEPTED, ACTUAL);
    }

    @Test
    public void deleteHumanFromListTest2() {
        final Human HUMAN_FOR_DELETE = new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final Human[] HUMANS_EXCEPTED = {new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final List<Human> EXCEPTED = new ArrayList<>(Arrays.asList(HUMANS_EXCEPTED));
        final int EXCEPTED_LIST_SIZE = EXCEPTED.size();

        final List<Human> ACTUAL = CollectionsDemo.deleteHumanFromList(HUMANS, HUMAN_FOR_DELETE);

        assert ACTUAL != null;
        final int ACTUAL_LIST_SIZE = ACTUAL.size();

        Assert.assertEquals(EXCEPTED_LIST_SIZE, ACTUAL_LIST_SIZE);
        Assert.assertEquals(EXCEPTED, ACTUAL);
    }

    @Test
    public void deleteHumanFromListTest3() {
        final Human HUMAN_FOR_DELETE = new Human("Borisov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);
        final int EXCEPTED_LIST_SIZE = HUMANS.size();

        final List<Human> ACTUAL = CollectionsDemo.deleteHumanFromList(HUMANS, HUMAN_FOR_DELETE);

        assert ACTUAL != null;
        final int ACTUAL_LIST_SIZE = ACTUAL.size();

        Assert.assertEquals(EXCEPTED_LIST_SIZE, ACTUAL_LIST_SIZE);
        Assert.assertEquals(HUMANS, ACTUAL);
    }
}
