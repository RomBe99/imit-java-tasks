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
    private final ArrayList<Human> HUMANS = new ArrayList<>(Arrays.asList(
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

        final Human[] HUMANS_EXPECTED = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final List<Human> ACTUAL = CollectionsDemo.deleteHumanFromList(HUMANS, HUMAN_FOR_DELETE);
        final List<Human> EXPECTED = new ArrayList<>(Arrays.asList(HUMANS_EXPECTED));

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void deleteHumanFromListTest2() {
        final Human HUMAN_FOR_DELETE = new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final Human[] HUMANS_EXPECTED = {new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final List<Human> ACTUAL = CollectionsDemo.deleteHumanFromList(HUMANS, HUMAN_FOR_DELETE);
        final List<Human> EXPECTED = new ArrayList<>(Arrays.asList(HUMANS_EXPECTED));

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void deleteHumanFromListTest3() {
        final Human HUMAN_FOR_DELETE = new Human("Borisov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final List<Human> ACTUAL = CollectionsDemo.deleteHumanFromList(HUMANS, HUMAN_FOR_DELETE);

        Assert.assertEquals(HUMANS, ACTUAL);
    }
}
