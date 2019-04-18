package ru.omsu.imit.javatasks.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionsDemoTest {
    private final String TEST_NAME = "Ivan";
    private final String TEST_PATRONYMIC = "Ivanovich";
    private final int TEST_AGE = 20;

    @Test
    public void deleteHumanFromListTest1() {
        final Human HUMAN_FOR_DELETE = new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final Human[] HUMANS = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final Human[] HUMANS_EXPECTED = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final ArrayList<Human> ACTUAL = CollectionsDemo.deleteHumanFromList(new ArrayList<>(Arrays.asList(HUMANS)), HUMAN_FOR_DELETE);
        final ArrayList<Human> EXPECTED = new ArrayList<>(Arrays.asList(HUMANS_EXPECTED));

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void deleteHumanFromListTest2() {
        final Human HUMAN_FOR_DELETE = new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final Human[] HUMANS = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final Human[] HUMANS_EXPECTED = {new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final ArrayList<Human> ACTUAL = CollectionsDemo.deleteHumanFromList(new ArrayList<>(Arrays.asList(HUMANS)), HUMAN_FOR_DELETE);
        final ArrayList<Human> EXPECTED = new ArrayList<>(Arrays.asList(HUMANS_EXPECTED));

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void deleteHumanFromListTest3() {
        final Human HUMAN_FOR_DELETE = new Human("Borisov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final Human[] HUMANS = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final ArrayList<Human> ACTUAL = CollectionsDemo.deleteHumanFromList(new ArrayList<>(Arrays.asList(HUMANS)), HUMAN_FOR_DELETE);
        final ArrayList<Human> EXPECTED = new ArrayList<>(Arrays.asList(HUMANS));

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    // TODO Сделать тесты для listAllDisjointSets
    @Test
    public void listAllDisjointSetsTest1() {
    }

    @Test
    public void listAllDisjointSetsTest2() {

    }

    // TODO Сделать тесты для maxAge
    @Test
    public void maxAgeTest1() {
    }

    @Test
    public void maxAgeTest2() {
    }

    // TODO Сделать тесты для humanFilter
    @Test
    public void humanFilter1() {
    }

    @Test
    public void humanFilter2() {
    }
}