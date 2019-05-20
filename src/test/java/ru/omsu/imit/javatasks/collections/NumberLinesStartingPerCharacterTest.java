package ru.omsu.imit.javatasks.collections;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberLinesStartingPerCharacterTest extends Assert {

    @DataProvider
    public Object[][] numberLinesStartingPerCharacterTestData() {
        final List<String> STRING_ARRAY_LIST = new ArrayList<>(Arrays.asList(
            "John", "", "Ken", "Oscar", null, "Jasmine", "Olivia", "Ollie", "Kai", "Victoria", "Jessica", "Oliver"));

        return new Object[][]{
                {new ArrayList<String>(), '7', 0},
                {STRING_ARRAY_LIST, 'z', 0},
                {STRING_ARRAY_LIST, 'V', 1},
                {STRING_ARRAY_LIST, 'K', 2}
        };
    }

    @Test(dataProvider = "numberLinesStartingPerCharacterTestData")
    public void numberLinesStartingPerCharacterTest
            (final List<String> listForTest, final char startCharForTest, final int expected) {
        final int ACTUAL = CollectionsDemo.numberLinesStartingPerCharacter(listForTest, startCharForTest);

        assertEquals(ACTUAL, expected);
    }
}
