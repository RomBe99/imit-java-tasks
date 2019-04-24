package ru.omsu.imit.javatasks.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MaxAgeTest {
    private final String TEST_NAME = "Ivan";
    private final String TEST_PATRONYMIC = "Ivanovich";
    private final String TEST_SURNAME = "Ivanov";
    private final int TEST_AGE = 20;
    private ArrayList<Human> humans = new ArrayList<>(Arrays.asList(
            new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
            new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
            new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
            new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
            new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
            new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, TEST_AGE)));

    @Test
    public void maxAgeTest0() {
        final int SIZE = 1;
        HashSet<Human> excepted = new HashSet<>(SIZE);
        excepted.add(humans.get(0));

        final int NEW_AGE = 20;

        for (Human human : humans) {
            human.setAge(NEW_AGE);
        }

        Assert.assertEquals(excepted, CollectionsDemo.maxAge(humans));
    }
}