package ru.omsu.imit.javatasks.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionsDemoTest {
    private final String TEST_NAME = "Ivan";
    private final String TEST_PATRONYMIC = "Ivanovich";
    private final int TEST_AGE = 20;

    @Test
    public void numberLinesStartingPerCharacterTest1() {
        final String[] NAMES = {"John", "Ken", "Oscar", "Jasmine", "Olivia", "Ollie", "Kai", "Victoria", "Jessica", "Oliver"};
        final ArrayList<String> STRING_ARRAY_LIST = new ArrayList<>(Arrays.asList(NAMES));
        final int EXPECTED = 0;
        final char START_CHAR = 'z';
        final int ACTUAL = CollectionsDemo.numberLinesStartingPerCharacter(STRING_ARRAY_LIST, START_CHAR);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void numberLinesStartingPerCharacterTest2() {
        final String[] NAMES = {"John", "Ken", "Oscar", "Jasmine", "Olivia", "Ollie", "Kai", "Victoria", "Jessica", "Oliver"};
        final ArrayList<String> STRING_ARRAY_LIST = new ArrayList<>(Arrays.asList(NAMES));
        final int EXPECTED = 1;
        final char START_CHAR = 'V';
        final int ACTUAL = CollectionsDemo.numberLinesStartingPerCharacter(STRING_ARRAY_LIST, START_CHAR);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void numberLinesStartingPerCharacterTest3() {
        final String[] NAMES = {"John", "Ken", "Oscar", "Jasmine", "Olivia", "Ollie", "Kai", "Victoria", "Jessica", "Oliver"};
        final ArrayList<String> STRING_ARRAY_LIST = new ArrayList<>(Arrays.asList(NAMES));
        final int EXPECTED = 2;
        final char START_CHAR = 'K';
        final int ACTUAL = CollectionsDemo.numberLinesStartingPerCharacter(STRING_ARRAY_LIST, START_CHAR);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void numberLinesStartingPerCharacterTest4() {
        final String[] NAMES = {"John", "Ken", "Oscar", "Jasmine", "Olivia", "Ollie", "Kai", "Victoria", "Jessica", "Oliver"};
        final ArrayList<String> STRING_ARRAY_LIST = new ArrayList<>(Arrays.asList(NAMES));
        final int EXPECTED = 3;
        final char START_CHAR = 'J';
        final int ACTUAL = CollectionsDemo.numberLinesStartingPerCharacter(STRING_ARRAY_LIST, START_CHAR);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void numberLinesStartingPerCharacterTest5() {
        final String[] NAMES = {"John", "Ken", "Oscar", "Jasmine", "Olivia", "Ollie", "Kai", "Victoria", "Jessica", "Oliver"};
        final ArrayList<String> STRING_ARRAY_LIST = new ArrayList<>(Arrays.asList(NAMES));
        final int EXPECTED = 4;
        final char START_CHAR = 'O';
        final int ACTUAL = CollectionsDemo.numberLinesStartingPerCharacter(STRING_ARRAY_LIST, START_CHAR);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void numberLinesStartingPerCharacterTest6() {
        final ArrayList<String> STRING_ARRAY_LIST = new ArrayList<>();
        final int EXPECTED = 0;
        final char START_CHAR = 'O';
        final int ACTUAL = CollectionsDemo.numberLinesStartingPerCharacter(STRING_ARRAY_LIST, START_CHAR);

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void findNamesakesFromListTest1() {
        final String SURNAME = "Vsileev";

        final Human[] HUMANS = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final ArrayList<Human> ACTUAL = CollectionsDemo.findNamesakesFromList(new ArrayList<>(Arrays.asList(HUMANS)), SURNAME);
        final ArrayList<Human> EXPECTED = new ArrayList<>();

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void findNamesakesFromListTest2() {
        final String SURNAME = "Shumov";

        final Human[] HUMANS = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final Human[] HUMANS_EXPECTED = {new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final ArrayList<Human> ACTUAL = CollectionsDemo.findNamesakesFromList(new ArrayList<>(Arrays.asList(HUMANS)), SURNAME);
        final ArrayList<Human> EXPECTED = new ArrayList<>(Arrays.asList(HUMANS_EXPECTED));

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void findNamesakesFromListTest3() {
        final String SURNAME = "Dubov";

        final Human[] HUMANS = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final Human[] HUMANS_EXPECTED = {new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final ArrayList<Human> ACTUAL = CollectionsDemo.findNamesakesFromList(new ArrayList<>(Arrays.asList(HUMANS)), SURNAME);
        final ArrayList<Human> EXPECTED = new ArrayList<>(Arrays.asList(HUMANS_EXPECTED));

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void findNamesakesFromListTest4() {
        final String SURNAME = "Andreev";

        final Human[] HUMANS = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final Human[] HUMANS_EXPECTED = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final ArrayList<Human> ACTUAL = CollectionsDemo.findNamesakesFromList(new ArrayList<>(Arrays.asList(HUMANS)), SURNAME);
        final ArrayList<Human> EXPECTED = new ArrayList<>(Arrays.asList(HUMANS_EXPECTED));

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void deleteHumanFromListTest1() {
        final Human HUMAN_FOR_DELETE = new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final Human[] HUMANS = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final Human[] HUMANS_EXPECTED = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final ArrayList<Human> ACTUAL = CollectionsDemo.deleteHumanFromList(new ArrayList<>(Arrays.asList(HUMANS)), HUMAN_FOR_DELETE);
        final ArrayList<Human> EXPECTED = new ArrayList<>(Arrays.asList(HUMANS_EXPECTED));

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void deleteHumanFromListTest2() {
        final Human HUMAN_FOR_DELETE = new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final Human[] HUMANS = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final Human[] HUMANS_EXPECTED = {new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                         new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final ArrayList<Human> ACTUAL = CollectionsDemo.deleteHumanFromList(new ArrayList<>(Arrays.asList(HUMANS)), HUMAN_FOR_DELETE);
        final ArrayList<Human> EXPECTED = new ArrayList<>(Arrays.asList(HUMANS_EXPECTED));

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void deleteHumanFromListTest3() {
        final Human HUMAN_FOR_DELETE = new Human("Borisov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE);

        final Human[] HUMANS = {new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Shumov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Andreev", TEST_NAME, TEST_PATRONYMIC, TEST_AGE),
                                new Human("Dubov", TEST_NAME, TEST_PATRONYMIC, TEST_AGE)};

        final ArrayList<Human> ACTUAL = CollectionsDemo.deleteHumanFromList(new ArrayList<>(Arrays.asList(HUMANS)), HUMAN_FOR_DELETE);
        final ArrayList<Human> EXPECTED = new ArrayList<>(Arrays.asList(HUMANS));

        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    // TODO Сделать тесты для listAllDisjointSets
    @Test
    public void listAllDisjointSetsTest1() {
    }

    @Test
    public void listAllDisjointSetsTest2() {

    }

    // TODO Сделать тесты для maxAge
    @Test
    public void maxAgeTest1() {
    }

    @Test
    public void maxAgeTest2() {
    }

    // TODO Сделать тесты для humanFilter
    @Test
    public void humanFilter1() {
    }

    @Test
    public void humanFilter2() {
    }
}