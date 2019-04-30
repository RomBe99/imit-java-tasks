package ru.omsu.imit.javatasks.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HumansMoreEighteensYearsOldTest {
    private Map<Integer, Human> humanHashMapForTest;
    private final String TEST_SURNAME = "Ivanov";
    private final String TEST_NAME = "Ivan";
    private final String TEST_PATRONYMIC = "Ivanovich";
    private final int SIZE = 6;

    @Test
    public void humansMoreEighteensYearsOldTest0() {
        humanHashMapForTest = new HashMap<>();

        Assert.assertNull(CollectionsDemo.humansMoreEighteensYearsOld(humanHashMapForTest));
    }

    @Test
    public void humansMoreEighteensYearsOldTest1() {
        humanHashMapForTest = new HashMap<>(SIZE);

        Assert.assertNull(CollectionsDemo.humansMoreEighteensYearsOld(humanHashMapForTest));
    }

    @Test
    public void humansMoreEighteensYearsOldTest2() {
        final int[] KEYS = {2, 3, 4};
        final int[] AGES = {16, 15, 9};

        final List<Integer> EXPECTED = new ArrayList<>();

        humanHashMapForTest = new HashMap<>(SIZE);
        humanHashMapForTest.put(KEYS[0], new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, AGES[0]));
        humanHashMapForTest.put(KEYS[1], new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, AGES[1]));
        humanHashMapForTest.put(KEYS[2], new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, AGES[2]));

        final List<Integer> ACTUAL = CollectionsDemo.humansMoreEighteensYearsOld(humanHashMapForTest);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void humansMoreEighteensYearsOldTest3() {
        final int[] KEYS = {2, 3, 4};
        final int[] AGES = {16, 24, 18};
        final int EXPECTED_LIST_SIZE = 2;

        final List<Integer> EXPECTED = new ArrayList<>(EXPECTED_LIST_SIZE);
        EXPECTED.add(KEYS[1]);
        EXPECTED.add(KEYS[2]);

        humanHashMapForTest = new HashMap<>(SIZE);
        humanHashMapForTest.put(KEYS[0], new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, AGES[0]));
        humanHashMapForTest.put(KEYS[1], new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, AGES[1]));
        humanHashMapForTest.put(KEYS[2], new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, AGES[2]));

        final List<Integer> ACTUAL = CollectionsDemo.humansMoreEighteensYearsOld(humanHashMapForTest);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void humansMoreEighteensYearsOldTest4() {
        final int[] KEYS = {2, 3, 4};
        final int[] AGES = {21, 54, 71};
        final int EXPECTED_LIST_SIZE = 3;

        final List<Integer> EXPECTED = new ArrayList<>(EXPECTED_LIST_SIZE);
        EXPECTED.add(KEYS[0]);
        EXPECTED.add(KEYS[1]);
        EXPECTED.add(KEYS[2]);

        humanHashMapForTest = new HashMap<>(SIZE);
        humanHashMapForTest.put(KEYS[0], new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, AGES[0]));
        humanHashMapForTest.put(KEYS[1], new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, AGES[1]));
        humanHashMapForTest.put(KEYS[2], new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, AGES[2]));

        final List<Integer> ACTUAL = CollectionsDemo.humansMoreEighteensYearsOld(humanHashMapForTest);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void humansMoreEighteensYearsOldTest5() {
        final int[] KEYS = {0, 1, 2, 3, 4, 5};
        final int[] AGES = {13, 15, 9, 2, 1, 6};

        final List<Integer> EXPECTED = new ArrayList<>();

        humanHashMapForTest = new HashMap<>(SIZE);

        for (int i = 0; i < SIZE; i++) {
            humanHashMapForTest.put(KEYS[i], new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, AGES[i]));
        }

        final List<Integer> ACTUAL = CollectionsDemo.humansMoreEighteensYearsOld(humanHashMapForTest);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void humansMoreEighteensYearsOldTest6() {
        final int[] KEYS = {0, 1, 2, 3, 4, 5};
        final int[] AGES = {18, 15, 21, 22, 19, 60};
        final int EXPECTED_LIST_SIZE = 5;

        final List<Integer> EXPECTED = new ArrayList<>(EXPECTED_LIST_SIZE);
        EXPECTED.add(KEYS[0]);
        EXPECTED.add(KEYS[2]);
        EXPECTED.add(KEYS[3]);
        EXPECTED.add(KEYS[4]);
        EXPECTED.add(KEYS[5]);

        humanHashMapForTest = new HashMap<>(SIZE);

        for (int i = 0; i < SIZE; i++) {
            humanHashMapForTest.put(KEYS[i], new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, AGES[i]));
        }

        final List<Integer> ACTUAL = CollectionsDemo.humansMoreEighteensYearsOld(humanHashMapForTest);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void humansMoreEighteensYearsOldTest7() {
        final int[] KEYS = {0, 1, 2, 3, 4, 5};
        final int[] AGES = {18, 54, 21, 22, 19, 60};
        final int EXPECTED_LIST_SIZE = 6;

        final List<Integer> EXPECTED = new ArrayList<>(EXPECTED_LIST_SIZE);
        EXPECTED.add(KEYS[0]);
        EXPECTED.add(KEYS[1]);
        EXPECTED.add(KEYS[2]);
        EXPECTED.add(KEYS[3]);
        EXPECTED.add(KEYS[4]);
        EXPECTED.add(KEYS[5]);

        humanHashMapForTest = new HashMap<>(SIZE);

        for (int i = 0; i < SIZE; i++) {
            humanHashMapForTest.put(KEYS[i], new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, AGES[i]));
        }

        final List<Integer> ACTUAL = CollectionsDemo.humansMoreEighteensYearsOld(humanHashMapForTest);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }
}