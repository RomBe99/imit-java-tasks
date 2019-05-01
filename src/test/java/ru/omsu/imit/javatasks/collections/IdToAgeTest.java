package ru.omsu.imit.javatasks.collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IdToAgeTest {
    private Map<Integer, Human> humanHashMapForTest;
    private Set<Integer> filterForTest;
    private int[] keysForFilter;

    @Before
    public void setUp() {
        final String TEST_SURNAME = "Ivanov";
        final String TEST_NAME = "Ivan";
        final String TEST_PATRONYMIC = "Ivanovich";
        final int[] AGES = {3, 39, 25, 32, 39, 21};
        final int[] KEYS = {41, 28, 35, 22, 9, 49};
        final int HASH_MAP_SIZE = 6;

        humanHashMapForTest = new HashMap<>(HASH_MAP_SIZE);

        for (int i = 0; i < HASH_MAP_SIZE; i++) {
            humanHashMapForTest.put(KEYS[i], new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, AGES[i]));
        }
    }

    @Test
    public void idToAgeTest0() {
        Assert.assertNull(CollectionsDemo.idToAge(new HashMap<Integer, Human>(), new HashSet<Integer>()));
    }

    @Test
    public void idToAgeTest1() {
        final Map<Integer, Integer> EXPECTED = new HashMap<>();
        final Map<Integer, Integer> ACTUAL = CollectionsDemo.idToAge(humanHashMapForTest, new HashSet<Integer>());

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void idToAgeTest2() {
        final int EXPECTED_HASH_MAP_SIZE = 0;
        final int FILTER_FOR_TEST_SIZE = 3;
        final Map<Integer, Integer> EXPECTED = new HashMap<>();

        keysForFilter = new int[]{2, 20, 40};

        filterForTest = new HashSet<>(FILTER_FOR_TEST_SIZE);

        for (int i = 0; i < FILTER_FOR_TEST_SIZE; i++) {
            filterForTest.add(keysForFilter[i]);
        }

        final Map<Integer, Integer> ACTUAL = CollectionsDemo.idToAge(humanHashMapForTest, filterForTest);

        assert ACTUAL != null;
        final int ACTUAL_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_HASH_MAP_SIZE, ACTUAL_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void idToAgeTest3() {
        final int EXPECTED_HASH_MAP_SIZE = 4;
        final int FILTER_FOR_TEST_SIZE = 4;
        final int[] KEYS = {41, 28, 35, 22, 9, 49};

        final Map<Integer, Integer> EXPECTED = new HashMap<>(EXPECTED_HASH_MAP_SIZE);

        for (int i = 0; i < EXPECTED_HASH_MAP_SIZE; i++) {
            EXPECTED.put(KEYS[i], humanHashMapForTest.get(KEYS[i]).getAge());
        }

        keysForFilter = new int[]{41, 35, 9, 49};

        filterForTest = new HashSet<>(FILTER_FOR_TEST_SIZE);

        for (int i = 0; i < FILTER_FOR_TEST_SIZE; i++) {
            filterForTest.add(KEYS[i]);
        }

        final Map<Integer, Integer> ACTUAL = CollectionsDemo.idToAge(humanHashMapForTest, filterForTest);

        assert ACTUAL != null;
        final int ACTUAL_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_HASH_MAP_SIZE, ACTUAL_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void idToAgeTest4() {
        final int EXPECTED_HASH_MAP_SIZE = 6;
        final int FILTER_FOR_TEST_SIZE = 6;
        final int[] KEYS = {41, 28, 35, 22, 9, 49};

        final Map<Integer, Integer> EXPECTED = new HashMap<>(EXPECTED_HASH_MAP_SIZE);

        for (int i = 0; i < EXPECTED_HASH_MAP_SIZE; i++) {
            EXPECTED.put(KEYS[i], humanHashMapForTest.get(KEYS[i]).getAge());
        }

        keysForFilter = new int[]{41, 28, 35, 22, 9, 49};

        filterForTest = new HashSet<>(FILTER_FOR_TEST_SIZE);

        for (int i = 0; i < FILTER_FOR_TEST_SIZE; i++) {
            filterForTest.add(KEYS[i]);
        }

        final Map<Integer, Integer> ACTUAL = CollectionsDemo.idToAge(humanHashMapForTest, filterForTest);

        assert ACTUAL != null;
        final int ACTUAL_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_HASH_MAP_SIZE, ACTUAL_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }
}