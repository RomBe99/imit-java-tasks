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
    private Set<Integer> filterForTest;

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

        filterForTest = new HashSet<>(FILTER_SIZE);
        filterForTest.add(12);

        final Set<Human> ACTUAL = CollectionsDemo.humanFilter(new HashMap<Integer, Human>(), filterForTest);

        Assert.assertNull(ACTUAL);
    }

    @Test
    public void humanFilterTest1() {
        final int FILTER_SIZE = 2;
        final int[] FILTER_VALUES = {12, 52};

        filterForTest = new HashSet<>(FILTER_SIZE);
        for (int i : FILTER_VALUES) {
            filterForTest.add(i);
        }

        final Set<Human> ACTUAL = CollectionsDemo.humanFilter(new HashMap<Integer, Human>(), filterForTest);

        Assert.assertNull(ACTUAL);
    }

    @Test
    public void humanFilterTest2() {
        final Set<Human> EXPECTED = new HashSet<>(humanHashMapForTest.values());
        final int EXPECTED_SET_SIZE = EXPECTED.size();
        final Set<Human> ACTUAL = CollectionsDemo.humanFilter(humanHashMapForTest, new HashSet<Integer>());

        assert ACTUAL != null;
        final int ACTUAL_SET_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_SET_SIZE, ACTUAL_SET_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void humanFilterTest3() {
        final int EXPECTED_FILTER_SIZE = 2;
        final int EXPECTED_SET_SIZE = 2;
        final int[] FILTER_VALUES = {2, 5};

        filterForTest = new HashSet<>(EXPECTED_FILTER_SIZE);

        for (int i : FILTER_VALUES) {
            filterForTest.add(i);
        }

        final Set<Human> EXCEPTED = new HashSet<>(EXPECTED_SET_SIZE);

        for (int i : FILTER_VALUES) {
            EXCEPTED.add(humanHashMapForTest.get(i));
        }

        final Set<Human> ACTUAL = CollectionsDemo.humanFilter(humanHashMapForTest, filterForTest);

        assert ACTUAL != null;
        final int ACTUAL_SET_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_SET_SIZE, ACTUAL_SET_SIZE);
        Assert.assertEquals(EXCEPTED, ACTUAL);
    }

    @Test
    public void humanFilterTest4() {
        final int FILTER_SIZE = 3;
        final int EXPECTED_SET_SIZE = 3;
        final int[] FILTER_VALUES = {2, 5, 0};

        final Set<Human> EXPECTED = new HashSet<>(FILTER_SIZE);
        for (int i : FILTER_VALUES) {
            EXPECTED.add(humanHashMapForTest.get(i));
        }

        filterForTest = new HashSet<>(FILTER_SIZE);
        for (int i : FILTER_VALUES) {
            filterForTest.add(i);
        }

        final Set<Human> ACTUAL = CollectionsDemo.humanFilter(humanHashMapForTest, filterForTest);

        assert ACTUAL != null;
        final int ACTUAL_SET_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_SET_SIZE, ACTUAL_SET_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void humanFilterTest5() {
        final Set<Integer> FILTER_FOR_TEST = new HashSet<>(humanHashMapForTest.keySet());

        final Set<Human> EXPECTED = new HashSet<>(humanHashMapForTest.values());
        final int EXPECTED_SET_SIZE = EXPECTED.size();

        final Set<Human> ACTUAL = CollectionsDemo.humanFilter(humanHashMapForTest, FILTER_FOR_TEST);

        assert ACTUAL != null;
        final int ACTUAL_SET_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_SET_SIZE, ACTUAL_SET_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }
}