package ru.omsu.imit.javatasks.collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxAgeTest {
    private List<Human> humans;

    @Before
    public void setUp() {
        final String TEST_NAME = "Ivan";
        final String TEST_PATRONYMIC = "Ivanovich";
        final String TEST_SURNAME = "Ivanov";
        final int TEST_AGE = 20;

        humans = new ArrayList<>(Arrays.asList(
                new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, TEST_AGE)));
    }

    @Test
    public void maxAgeTest0() {
        final int SIZE = 1;
        final int NEW_AGE = 20;

        Set<Human> excepted = new HashSet<>(SIZE);
        excepted.add(humans.get(0));

        for (Human human : humans) {
            human.setAge(NEW_AGE);
        }

        Assert.assertEquals(excepted, CollectionsDemo.maxAge(humans));
    }

    @Test
    public void maxAgeTest1() {
        final int SIZE = 1;
        final int NEW_AGE = 30;

        Set<Human> excepted = new HashSet<>(SIZE);

        humans.get(3).setAge(NEW_AGE);
        excepted.add(humans.get(3));

        Assert.assertEquals(excepted, CollectionsDemo.maxAge(humans));
    }

    @Test
    public void maxAgeTest2() {
        final int SIZE = 3;
        final String NAME1 = "Roman";
        final String NAME2 = "Stanislav";
        final String NAME3 = "Igor";
        final int NEW_AGE = 30;
        final int[] HUMAN_NUMBERS = {1, 3, 5};

        Set<Human> excepted = new HashSet<>(SIZE);

        humans.get(HUMAN_NUMBERS[0]).setAge(NEW_AGE);
        humans.get(HUMAN_NUMBERS[1]).setAge(NEW_AGE);
        humans.get(HUMAN_NUMBERS[2]).setAge(NEW_AGE);

        humans.get(HUMAN_NUMBERS[0]).setName(NAME1);
        humans.get(HUMAN_NUMBERS[1]).setName(NAME2);
        humans.get(HUMAN_NUMBERS[2]).setName(NAME3);


        excepted.add(humans.get(HUMAN_NUMBERS[0]));
        excepted.add(humans.get(HUMAN_NUMBERS[1]));
        excepted.add(humans.get(HUMAN_NUMBERS[2]));

        Assert.assertEquals(excepted, CollectionsDemo.maxAge(humans));
    }
}