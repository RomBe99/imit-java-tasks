package ru.omsu.imit.javatasks.collections;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class IdToAgeTest extends Assert {

    @DataProvider
    public Object[][] idToAgeTestData() {
        final String TEST_SURNAME = "Ivanov";
        final String TEST_NAME = "Ivan";
        final String TEST_PATRONYMIC = "Ivanovich";
        final int[] AGES = {3, 39, 25, 32, 39, 21};
        final int[] KEYS = {41, 28, 35, 22, 9, 49};
        final int MAP_SIZE = 6;

        final Map<Integer, Human> HUMAN_MAP_FOR_TEST = new HashMap<>(MAP_SIZE);
        for (int i = 0; i < MAP_SIZE; i++) {
            HUMAN_MAP_FOR_TEST.put(KEYS[i], new Human(TEST_SURNAME, TEST_NAME, TEST_PATRONYMIC, AGES[i]));
        }

        final Map<Integer, Integer> EXPECTED_LIST = new HashMap<>(MAP_SIZE);
        for (int i = 0; i < MAP_SIZE; i++) {
            EXPECTED_LIST.put(KEYS[i], AGES[i]);
        }

        return new Object[][]{
                {new HashMap<Integer, Human>(), new HashMap<Integer, Integer>()},
                {HUMAN_MAP_FOR_TEST, EXPECTED_LIST}
        };
    }

    @Test(dataProvider = "idToAgeTestData")
    public void idToAgeTest(final Map<Integer, Human> humanMapForTest, final Map<Integer, Human> expectedList) {
        final Map<Integer, Integer> ACTUAL = CollectionsDemo.idToAge(humanMapForTest);
        final int EXPECTED_MAP_SIZE = expectedList.size();

        assert ACTUAL != null;
        final int ACTUAL_SIZE = ACTUAL.size();

        assertEquals(ACTUAL_SIZE, EXPECTED_MAP_SIZE);
        assertEquals(ACTUAL, expectedList);
    }
}