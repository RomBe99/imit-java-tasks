package ru.omsu.imit.javatasks.collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HumanFilterTest {
    private Map<Integer, Human> humanHashMapForTest;

    @Before
    public void setUp() {
        final String TEST_NAME = "Ivan";
        final String TEST_PATRONYMIC = "Ivanovich";
        final String TEST_SURNAME = "Ivanov";
        final int SIZE = 6;

        humanHashMapForTest = new HashMap<>(SIZE);

        for (int i = 0; i < SIZE; i++) {
            humanHashMapForTest.put(i, new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, i));
        }
    }

    @Test
    public void humanFilterTest0() {
        final int FILTER_SIZE = 1;

        Set<Integer> filterForTest = new HashSet<>(FILTER_SIZE);
        filterForTest.add(12);

        final Set<Human> ACTUAL = CollectionsDemo.humanFilter(new HashMap<Integer, Human>(), filterForTest);

        Assert.assertNull(ACTUAL);
    }

    @Test
    public void humanFilterTest1() {
        final int FILTER_SIZE = 2;
        final int[] FILTER_VALUES = {12, 52};

        Set<Integer> filterForTest = new HashSet<>(FILTER_SIZE);
        filterForTest.add(FILTER_VALUES[0]);
        filterForTest.add(FILTER_VALUES[1]);

        final Set<Human> ACTUAL = CollectionsDemo.humanFilter(new HashMap<Integer, Human>(), filterForTest);

        Assert.assertNull(ACTUAL);
    }

    @Test
    public void humanFilterTest2() {
        final Set<Human> ACTUAL = CollectionsDemo.humanFilter(humanHashMapForTest, new HashSet<Integer>());
        final Set<Human> EXCEPTED = new HashSet<>(humanHashMapForTest.values());

        Assert.assertEquals(EXCEPTED, ACTUAL);
    }

    @Test
    public void humanFilterTest3() {
        final int FILTER_SIZE = 2;
        final int[] FILTER_VALUES = {2, 5};

        Set<Integer> filter = new HashSet<>(FILTER_SIZE);
        filter.add(FILTER_VALUES[0]);
        filter.add(FILTER_VALUES[1]);

        Set<Human> excepted = new HashSet<>(FILTER_SIZE);
        excepted.add(humanHashMapForTest.get(FILTER_VALUES[0]));
        excepted.add(humanHashMapForTest.get(FILTER_VALUES[1]));

        final Set<Human> ACTUAL = CollectionsDemo.humanFilter(humanHashMapForTest, filter);

        Assert.assertEquals(excepted, ACTUAL);
    }

    @Test
    public void humanFilterTest4() {
        final int FILTER_SIZE = 2;
        final int[] FILTER_VALUES = {2, 5, 0};

        Set<Integer> filter = new HashSet<>(FILTER_SIZE);
        filter.add(FILTER_VALUES[0]);
        filter.add(FILTER_VALUES[1]);
        filter.add(FILTER_VALUES[2]);

        Set<Human> excepted = new HashSet<>(FILTER_SIZE);
        excepted.add(humanHashMapForTest.get(FILTER_VALUES[0]));
        excepted.add(humanHashMapForTest.get(FILTER_VALUES[1]));
        excepted.add(humanHashMapForTest.get(FILTER_VALUES[2]));

        final Set<Human> ACTUAL = CollectionsDemo.humanFilter(humanHashMapForTest, filter);

        Assert.assertEquals(excepted, ACTUAL);
    }

    @Test
    public void humanFilterTest5() {
        final Set<Integer> FILTER = new HashSet<>(humanHashMapForTest.keySet());
        final Set<Human> EXCEPTED = new HashSet<>(humanHashMapForTest.values());
        final Set<Human> ACTUAL = CollectionsDemo.humanFilter(humanHashMapForTest, FILTER);

        Assert.assertEquals(EXCEPTED, ACTUAL);
    }
}