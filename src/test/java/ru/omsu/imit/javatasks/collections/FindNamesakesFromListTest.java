package ru.omsu.imit.javatasks.collections;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindNamesakesFromListTest extends Assert {

    @DataProvider
    public Object[][] findNamesakesFromListTestData() {
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

        final Human NAMESAKE_1 = new Human("Vsileev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);
        final Human NAMESAKE_2 = new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);
        final Human NAMESAKE_3 = new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);
        final Human NAMESAKE_4 = new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final List<Human> EXPECTED_LIST_FOR_2_TEST = new ArrayList<>(Collections.singletonList(new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)));
        final List<Human> EXPECTED_LIST_FOR_3_TEST = new ArrayList<>(Arrays.asList(new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE), new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)));
        final List<Human> EXPECTED_LIST_FOR_4_TEST = new ArrayList<>(Arrays.asList(new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE), new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE), new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)));

        return new Object[][]{
                {new ArrayList<Human>(), NAMESAKE_1, new ArrayList<Human>()},
                {HUMANS, NAMESAKE_1, new ArrayList<Human>()},
                {HUMANS, NAMESAKE_2, EXPECTED_LIST_FOR_2_TEST},
                {HUMANS, NAMESAKE_3, EXPECTED_LIST_FOR_3_TEST},
                {HUMANS, NAMESAKE_4, EXPECTED_LIST_FOR_4_TEST}
        };
    }

    @Test(dataProvider = "findNamesakesFromListTestData")
    public void findNamesakesFromListTest(final List<Human> listForTest, final Human namesake, final List<Human> expectedList) {
        final int EXPECTED_LIST_SIZE = expectedList.size();

        final List<Human> ACTUAL = CollectionsDemo.findNamesakesFromList(listForTest, namesake);

        assert ACTUAL != null;
        final int ACTUAL_LIST_SIZE = ACTUAL.size();

        Assert.assertEquals(ACTUAL_LIST_SIZE, EXPECTED_LIST_SIZE);
        Assert.assertEquals(ACTUAL, expectedList);
    }
}