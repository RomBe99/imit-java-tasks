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
        final int EXCEPTED_SIZE = 1;
        final int NEW_AGE = 20;

        final Set<Human> EXCEPTED = new HashSet<>(EXCEPTED_SIZE);
        EXCEPTED.add(humans.get(0));

        for (Human human : humans) {
            human.setAge(NEW_AGE);
        }

        final Set<Human> ACTUAL = CollectionsDemo.maxAge(humans);

        assert ACTUAL != null;
        final int ACTUAL_SET_SIZE = ACTUAL.size();

        Assert.assertEquals(EXCEPTED_SIZE, ACTUAL_SET_SIZE);
        Assert.assertEquals(EXCEPTED, ACTUAL);
    }

    @Test
    public void maxAgeTest1() {
        final int EXCEPTED_SIZE = 1;
        final int NEW_AGE = 30;

        final Set<Human> EXCEPTED = new HashSet<>(EXCEPTED_SIZE);

        humans.get(3).setAge(NEW_AGE);
        EXCEPTED.add(humans.get(3));

        final Set<Human> ACTUAL = CollectionsDemo.maxAge(humans);

        assert ACTUAL != null;
        final int ACTUAL_SET_SIZE = ACTUAL.size();

        Assert.assertEquals(EXCEPTED_SIZE, ACTUAL_SET_SIZE);
        Assert.assertEquals(EXCEPTED, ACTUAL);
    }

    @Test
    public void maxAgeTest2() {
        final int EXCEPTED_SIZE = 3;
        final String[] NAMES = {"Roman", "Stanislav", "Igor"};
        final int NEW_AGE = 30;
        final int[] HUMAN_NUMBERS = {1, 3, 5};

        final Set<Human> EXCEPTED = new HashSet<>(EXCEPTED_SIZE);

        for (int i = 0; i < EXCEPTED_SIZE; i++) {
            humans.get(HUMAN_NUMBERS[i]).setName(NAMES[i]);
        }

        for (int i : HUMAN_NUMBERS) {
            humans.get(i).setAge(NEW_AGE);
            EXCEPTED.add(humans.get(i));
        }

        final Set<Human> ACTUAL = CollectionsDemo.maxAge(humans);

        assert ACTUAL != null;
        final int ACTUAL_SET_SIZE = ACTUAL.size();

        Assert.assertEquals(EXCEPTED_SIZE, ACTUAL_SET_SIZE);
        Assert.assertEquals(EXCEPTED, ACTUAL);
    }
}