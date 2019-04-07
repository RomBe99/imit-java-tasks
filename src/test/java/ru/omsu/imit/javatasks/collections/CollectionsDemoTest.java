package ru.omsu.imit.javatasks.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionsDemoTest {
    @Test
    public void numberLinesStartingPerCharacterTest1() {
        final String[] STRINGS = {"John", "Ken", "Oscar", "Jasmine", "Olivia", "Ollie", "Kai", "Victoria", "Jessica", "Oliver"};
        final ArrayList<String> STRING_ARRAY_LIST = new ArrayList<>(Arrays.asList(STRINGS));
        final int EXPECTED = 0;
        final char START_CHAR = 'z';
        final int ACTUAL = CollectionsDemo.numberLinesStartingPerCharacter(STRING_ARRAY_LIST, START_CHAR);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void numberLinesStartingPerCharacterTest2() {
        final String[] STRINGS = {"John", "Ken", "Oscar", "Jasmine", "Olivia", "Ollie", "Kai", "Victoria", "Jessica", "Oliver"};
        final ArrayList<String> STRING_ARRAY_LIST = new ArrayList<>(Arrays.asList(STRINGS));
        final int EXPECTED = 1;
        final char START_CHAR = 'V';
        final int ACTUAL = CollectionsDemo.numberLinesStartingPerCharacter(STRING_ARRAY_LIST, START_CHAR);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void numberLinesStartingPerCharacterTest3() {
        final String[] STRINGS = {"John", "Ken", "Oscar", "Jasmine", "Olivia", "Ollie", "Kai", "Victoria", "Jessica", "Oliver"};
        final ArrayList<String> STRING_ARRAY_LIST = new ArrayList<>(Arrays.asList(STRINGS));
        final int EXPECTED = 2;
        final char START_CHAR = 'K';
        final int ACTUAL = CollectionsDemo.numberLinesStartingPerCharacter(STRING_ARRAY_LIST, START_CHAR);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void numberLinesStartingPerCharacterTest4() {
        final String[] STRINGS = {"John", "Ken", "Oscar", "Jasmine", "Olivia", "Ollie", "Kai", "Victoria", "Jessica", "Oliver"};
        final ArrayList<String> STRING_ARRAY_LIST = new ArrayList<>(Arrays.asList(STRINGS));
        final int EXPECTED = 3;
        final char START_CHAR = 'J';
        final int ACTUAL = CollectionsDemo.numberLinesStartingPerCharacter(STRING_ARRAY_LIST, START_CHAR);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }
    @Test
    public void numberLinesStartingPerCharacterTest5() {
        final String[] STRINGS = {"John", "Ken", "Oscar", "Jasmine", "Olivia", "Ollie", "Kai", "Victoria", "Jessica", "Oliver"};
        final ArrayList<String> STRING_ARRAY_LIST = new ArrayList<>(Arrays.asList(STRINGS));
        final int EXPECTED = 4;
        final char START_CHAR = 'O';
        final int ACTUAL = CollectionsDemo.numberLinesStartingPerCharacter(STRING_ARRAY_LIST, START_CHAR);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    // TODO Сделать тесты для findNamesakesFromList

    // TODO Сделать тесты для deleteHumnaFromList
}