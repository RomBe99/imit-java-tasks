package ru.omsu.imit.javatasks.collections;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteHumanFromListTest  extends Assert {

    @DataProvider
    public Object[][] deleteHumanFromListTestData() {
        final String TEST_NAME = "Ivan";
        final String TEST_PATRONYMIC = "Ivanovich";
        final int TEST_AGE = 20;
        final List<Human> HUMANS = new ArrayList<>(Arrays.asList(
            new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
            new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
            new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
            new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
            new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
            new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)));

        final List<Human> EXPECTED_LIST_FOR_1_TEST = new ArrayList<>(Arrays.asList(new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE), new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE), new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE), new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE), new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)));
        final List<Human> EXPECTED_LIST_FOR_2_TEST = new ArrayList<>(Arrays.asList(new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE), new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE), new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)));

        final Human HUMAN_FOR_TEST_1 = new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);
        final Human HUMAN_FOR_TEST_2 = new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);
        final Human HUMAN_FOR_TEST_3 = new Human("Borisov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        return new Object[][]{
                {new ArrayList<Human>(), HUMAN_FOR_TEST_1, new ArrayList<>()},
                {HUMANS, HUMAN_FOR_TEST_1, EXPECTED_LIST_FOR_1_TEST},
                {HUMANS, HUMAN_FOR_TEST_2, EXPECTED_LIST_FOR_2_TEST},
                {HUMANS, HUMAN_FOR_TEST_3, HUMANS}
        };
    }

    @Test(dataProvider = "deleteHumanFromListTestData")
    public void deleteHumanFromListTest(final List<Human> listForTest, final Human humanForDelete, final List<Human> expectedList) {
        final int EXCEPTED_LIST_SIZE = expectedList.size();

        final List<Human> ACTUAL = CollectionsDemo.deleteHumanFromList(listForTest, humanForDelete);

        assert ACTUAL != null;
        final int ACTUAL_LIST_SIZE = ACTUAL.size();

        assertEquals(ACTUAL_LIST_SIZE, EXCEPTED_LIST_SIZE);
        assertEquals(ACTUAL, expectedList);
    }
}
