package ru.omsu.imit.javatasks.lambdas;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LambdaDemoTest extends Assert {
    @DataProvider
    public Object[][] lambdaStringLengthTestData() {
        final String[] STRINGS_FOR_TEST = new String[]{"", "Stas", "sadgdsaasdfASADF"};

        return new Object[][]{
                {STRINGS_FOR_TEST[0], STRINGS_FOR_TEST[0].length()},
                {STRINGS_FOR_TEST[1], STRINGS_FOR_TEST[1].length()},
                {STRINGS_FOR_TEST[2], STRINGS_FOR_TEST[2].length()}
        };
    }

    @Test(dataProvider = "lambdaStringLengthTestData")
    public void lambdaStringLengthTest(final String stringForTest, final Integer expected) {
        final Integer ACTUAL = LambdaDemo.stringLength.apply(stringForTest);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] lambdaFirstCharacterTestData() {
        final String[] STRINGS_FOR_TEST = new String[]{"", "Stas", "adgdsaasdfASADF", "-213", "228"};

        return new Object[][]{
                {STRINGS_FOR_TEST[0], null},
                {STRINGS_FOR_TEST[1], STRINGS_FOR_TEST[1].charAt(0)},
                {STRINGS_FOR_TEST[2], STRINGS_FOR_TEST[2].charAt(0)},
                {STRINGS_FOR_TEST[3], STRINGS_FOR_TEST[3].charAt(0)},
                {STRINGS_FOR_TEST[4], STRINGS_FOR_TEST[4].charAt(0)}
        };
    }

    @Test(dataProvider = "lambdaFirstCharacterTestData")
    public void lambdaFirstCharacterTest(final String stringForTest, final Character expected) {
        final Character ACTUAL = LambdaDemo.firstCharacter.apply(stringForTest);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] lambdaNotContainsSpacesTestData() {
        return new Object[][]{
                {null, false},
                {"", true},
                {"Stas", true},
                {"adgdsaa sdfASADF", false},
                {"- 2 1 3", false}
        };
    }

    @Test(dataProvider = "lambdaNotContainsSpacesTestData")
    public void lambdaNotContainsSpacesTest(final String stringForTest, final boolean expected) {
        final boolean ACTUAL = LambdaDemo.notContainsSpaces.test(stringForTest);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] lambdaWordsCountData() {
        final String[] STRINGS_FOR_TEST = new String[]{"", "Stas", "Stas,", "adgdsaa, sdfASADF", "- 2, 1, 3,"};

        return new Object[][]{
                {STRINGS_FOR_TEST[0], 0},
                {STRINGS_FOR_TEST[1], STRINGS_FOR_TEST[1].split(",").length},
                {STRINGS_FOR_TEST[2], STRINGS_FOR_TEST[2].split(",").length},
                {STRINGS_FOR_TEST[3], STRINGS_FOR_TEST[3].split(",").length}
        };
    }

    @Test(dataProvider = "lambdaWordsCountData")
    public void lambdaWordsCountTest(final String stringForTest, final Integer expected) {
        final Integer ACTUAL = LambdaDemo.wordsCount.apply(stringForTest);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] lambdaGetHumanAgeTestData() {
        final Human[] HUMANS_FOR_TEST = new Human[]{
                new Human("", "", "", 20, Gender.MALE),
                new Human("", "", "", 0, Gender.MALE),
                new Human("", "", "", 11, Gender.FEMALE)
        };

        return new Object[][]{
                {HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[0].getAge()},
                {HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[1].getAge()},
                {HUMANS_FOR_TEST[2], HUMANS_FOR_TEST[2].getAge()}
        };
    }

    @Test(dataProvider = "lambdaGetHumanAgeTestData")
    public void lambdaGetHumanAgeTest(final Human humanForTest, final Integer expected) {
        final Integer ACTUAL = LambdaDemo.getHumanAge.apply(humanForTest);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] lambdaIsNamesakeTestData() {
        final Human[] HUMANS_FOR_TEST = new Human[]{
                new Human("Stasov", "", "", 20, Gender.MALE),
                new Human("Ivanov", "", "", 0, Gender.MALE),
                new Human("Stasov", "", "", 11, Gender.MALE)
        };

        return new Object[][]{
                {HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[0], true},
                {HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[1], false},
                {HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[2], true}
        };
    }

    @Test(dataProvider = "lambdaIsNamesakeTestData")
    public void lambdaIsNamesakeTest(final Human humanForTest1, final Human humanForTest2, final boolean expected) {
        final boolean ACTUAL = LambdaDemo.isNamesake.check(humanForTest1, humanForTest2);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] lambdaGetFullNameTestData() {
        final Human[] HUMANS_FOR_TEST = new Human[]{
                new Human("Stasov", "Ivan", "Petrovich", 20, Gender.MALE),
                new Human("Ivanov", "Ilya", "Ivanovich", 0, Gender.MALE),
                new Human("Meganova", "Anita", "Ivanovna", 11, Gender.FEMALE)
        };

        return new Object[][]{
                {HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[0].getSurname() + HUMANS_FOR_TEST[0].getName() + HUMANS_FOR_TEST[0].getPatronymic()},
                {HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[1].getSurname() + HUMANS_FOR_TEST[1].getName() + HUMANS_FOR_TEST[1].getPatronymic()},
                {HUMANS_FOR_TEST[2], HUMANS_FOR_TEST[2].getSurname() + HUMANS_FOR_TEST[2].getName() + HUMANS_FOR_TEST[2].getPatronymic()}
        };
    }

    @Test(dataProvider = "lambdaGetFullNameTestData")
    public void lambdaGetFullNameTest(final Human humanForTest, final String expected) {
        final String ACTUAL = LambdaDemo.getFullName.apply(humanForTest);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] lambdaMakeHumanOlderTestData() {
        final Human[] HUMANS_FOR_TEST = new Human[]{
                new Human("Stasov", "Ivan", "Petrovich", 20, Gender.MALE),
                new Human("Ivanov", "Ilya", "Ivanovich", 0, Gender.MALE),
                new Human("Meganova", "Anita", "Ivanovna", 11, Gender.FEMALE)
        };

        return new Object[][]{
                {HUMANS_FOR_TEST[0], new Human("Stasov", "Ivan", "Petrovich", 21, Gender.MALE)},
                {HUMANS_FOR_TEST[1], new Human("Ivanov", "Ilya", "Ivanovich", 1, Gender.MALE)},
                {HUMANS_FOR_TEST[2], new Human("Meganova", "Anita", "Ivanovna", 12, Gender.FEMALE)}
        };
    }

    @Test(dataProvider = "lambdaMakeHumanOlderTestData")
    public void lambdaMakeHumanOlderTest(final Human humanForTest, final Human expected) {
        final Human ACTUAL = LambdaDemo.makeHumanOlder.apply(humanForTest);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] lambdaIsYoungerFilterTestData() {
        final Human[] HUMANS_FOR_TEST = new Human[]{
                new Human("Stasov", "Ivan", "Petrovich", 20, Gender.MALE),
                new Human("Ivanov", "Ilya", "Ivanovich", 1, Gender.MALE),
                new Human("Meganova", "Anita", "Ivanovna", 11, Gender.FEMALE)
        };

        return new Object[][]{
                {HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[2], 0, false},
                {HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[2], 2, false},
                {HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[2], 12, false},
                {HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[2], 20, false},
                {HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[2], 21, true},
                {HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[2], 50, true}
        };
    }

    @Test(dataProvider = "lambdaIsYoungerFilterTestData")
    public void lambdaIsYoungerFilterTest(final Human humanForTest1, final Human humanForTest2, final Human humanForTest3,
                                          final int filter, final boolean expected) {
        final boolean ACTUAL = LambdaDemo.isYoungerFilter.
                specialDataChecker(humanForTest1, humanForTest2, humanForTest3, filter);

        assertEquals(ACTUAL, expected);
    }
}