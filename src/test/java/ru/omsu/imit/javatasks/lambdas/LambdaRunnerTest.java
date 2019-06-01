package ru.omsu.imit.javatasks.lambdas;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.omsu.imit.javatasks.lambdas.functionalinterfaceses.IBinaryObjectsChecker;
import ru.omsu.imit.javatasks.lambdas.functionalinterfaceses.ISpecialDataChecker;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static ru.omsu.imit.javatasks.lambdas.LambdaRunner.run;

public class LambdaRunnerTest extends Assert {
    @DataProvider
    public Object[][] runFunctionsSITestData() {
        final String[] STRINGS_FOR_TEST1 = new String[]{"", "Stas", "sadgdsaasdfASADF"};
        final String[] STRINGS_FOR_TEST2 = new String[]{"", "Stas", "Stas,", "adgdsaa, sdfASADF", "- 2, 1, 3,"};

        return new Object[][]{
                {LambdaDemo.stringLength, STRINGS_FOR_TEST1[0], STRINGS_FOR_TEST1[0].length()},
                {LambdaDemo.stringLength, STRINGS_FOR_TEST1[1], STRINGS_FOR_TEST1[1].length()},
                {LambdaDemo.stringLength, STRINGS_FOR_TEST1[2], STRINGS_FOR_TEST1[2].length()},
                {LambdaDemo.wordsCount, STRINGS_FOR_TEST2[0], 0},
                {LambdaDemo.wordsCount, STRINGS_FOR_TEST2[1], STRINGS_FOR_TEST2[1].split(",").length},
                {LambdaDemo.wordsCount, STRINGS_FOR_TEST2[2], STRINGS_FOR_TEST2[2].split(",").length},
                {LambdaDemo.wordsCount, STRINGS_FOR_TEST2[3], STRINGS_FOR_TEST2[3].split(",").length}
        };
    }

    @Test(dataProvider = "runFunctionsSITestData")
    public void runFunctionsSITest(final Function<String, Integer> functionForTest, final String stringForTest, final Integer expected) {
        final Integer ACTUAL = run(functionForTest, stringForTest);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] runFunctionSCTestData() {
        final String[] STRINGS_FOR_TEST = new String[]{"", "Stas", "adgdsaasdfASADF", "-213", "228"};

        return new Object[][]{
                {LambdaDemo.firstCharacter, STRINGS_FOR_TEST[0], null},
                {LambdaDemo.firstCharacter, STRINGS_FOR_TEST[1], STRINGS_FOR_TEST[1].charAt(0)},
                {LambdaDemo.firstCharacter, STRINGS_FOR_TEST[2], STRINGS_FOR_TEST[2].charAt(0)},
                {LambdaDemo.firstCharacter, STRINGS_FOR_TEST[3], STRINGS_FOR_TEST[3].charAt(0)},
                {LambdaDemo.firstCharacter, STRINGS_FOR_TEST[4], STRINGS_FOR_TEST[4].charAt(0)}
        };
    }

    @Test(dataProvider = "runFunctionSCTestData")
    public void runFunctionSCTest(final Function<String, Character> functionForTest, final String stringForTest, final Character expected) {
        final Character ACTUAL = run(functionForTest, stringForTest);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] runPredicateSTestData() {
        return new Object[][]{
                {LambdaDemo.notContainsSpaces, null, false},
                {LambdaDemo.notContainsSpaces, "", true},
                {LambdaDemo.notContainsSpaces, "Stas", true},
                {LambdaDemo.notContainsSpaces, "adgdsaa sdfASADF", false},
                {LambdaDemo.notContainsSpaces, "- 2 1 3", false}
        };
    }

    @Test(dataProvider = "runPredicateSTestData")
    public void runPredicateSTest(final Predicate<String> predicateForTest, final String stringForTest, final boolean expected) {
        final boolean ACTUAL = run(predicateForTest, stringForTest);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] runFunctionsHITestData() {
        final Human[] HUMANS_FOR_TEST = new Human[]{
                new Human("", "", "", 20, Gender.MALE),
                new Human("", "", "", 0, Gender.MALE),
                new Human("", "", "", 11, Gender.FEMALE)
        };

        return new Object[][]{
                {LambdaDemo.getHumanAge, HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[0].getAge()},
                {LambdaDemo.getHumanAge, HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[1].getAge()},
                {LambdaDemo.getHumanAge, HUMANS_FOR_TEST[2], HUMANS_FOR_TEST[2].getAge()}
        };
    }

    @Test(dataProvider = "runFunctionsHITestData")
    public void runFunctionsHITest(final Function<Human, Integer> functionForTest, final Human humanForTest, final Integer expected) {
        final Integer ACTUAL = run(functionForTest, humanForTest);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] runIBinaryObjectsCheckerTestData() {
        final Human[] HUMANS_FOR_TEST = new Human[]{
                new Human("Stasov", "", "", 20, Gender.MALE),
                new Human("Ivanov", "", "", 0, Gender.MALE),
                new Human("Stasov", "", "", 11, Gender.MALE)
        };

        return new Object[][]{
                {LambdaDemo.isNamesake, HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[0], true},
                {LambdaDemo.isNamesake, HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[1], false},
                {LambdaDemo.isNamesake, HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[2], true}
        };
    }

    @Test(dataProvider = "runIBinaryObjectsCheckerTestData")
    public void runIBinaryObjectsCheckerTest(final IBinaryObjectsChecker<Human> checkerForTest,
                                             final Human humanForTest1, final Human humanForTest2, final boolean expected) {
        final boolean ACTUAL = LambdaRunner.run(checkerForTest, humanForTest1, humanForTest2);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] runFunctionsHSTestData() {
        final Human[] HUMANS_FOR_TEST = new Human[]{
                new Human("Stasov", "Ivan", "Petrovich", 20, Gender.MALE),
                new Human("Ivanov", "Ilya", "Ivanovich", 0, Gender.MALE),
                new Human("Meganova", "Anita", "Ivanovna", 11, Gender.FEMALE),
        };

        return new Object[][]{
                {LambdaDemo.getFullName, HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[0].getSurname() + HUMANS_FOR_TEST[0].getName() + HUMANS_FOR_TEST[0].getPatronymic()},
                {LambdaDemo.getFullName, HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[1].getSurname() + HUMANS_FOR_TEST[1].getName() + HUMANS_FOR_TEST[1].getPatronymic()},
                {LambdaDemo.getFullName, HUMANS_FOR_TEST[2], HUMANS_FOR_TEST[2].getSurname() + HUMANS_FOR_TEST[2].getName() + HUMANS_FOR_TEST[2].getPatronymic()}
        };
    }

    @Test(dataProvider = "runFunctionsHSTestData")
    public void runFunctionsHSTest(final Function<Human, String> functionForTest, final Human humanForTest, final String expected) {
        final String ACTUAL = run(functionForTest, humanForTest);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] runUnaryOperatorHTestData() {
        final Human[] HUMANS_FOR_TEST = new Human[]{
                new Human("Stasov", "Ivan", "Petrovich", 20, Gender.MALE),
                new Human("Ivanov", "Ilya", "Ivanovich", 0, Gender.MALE),
                new Human("Meganova", "Anita", "Ivanovna", 11, Gender.FEMALE)
        };

        return new Object[][]{
                {LambdaDemo.makeHumanOlder, HUMANS_FOR_TEST[0], new Human("Stasov", "Ivan", "Petrovich", 21, Gender.MALE)},
                {LambdaDemo.makeHumanOlder, HUMANS_FOR_TEST[1], new Human("Ivanov", "Ilya", "Ivanovich", 1, Gender.MALE)},
                {LambdaDemo.makeHumanOlder, HUMANS_FOR_TEST[2], new Human("Meganova", "Anita", "Ivanovna", 12, Gender.FEMALE)}
        };
    }

    @Test(dataProvider = "runUnaryOperatorHTestData")
    public void runUnaryOperatorHTest(final UnaryOperator<Human> unaryOperatorForTest, final Human humanForTest, final Human expected) {
        final Human ACTUAL = LambdaRunner.run(unaryOperatorForTest, humanForTest);

        assertEquals(ACTUAL, expected);
    }

    @DataProvider
    public Object[][] runISpecialDataCheckerTestData() {
        final Human[] HUMANS_FOR_TEST = new Human[]{
                new Human("Stasov", "Ivan", "Petrovich", 20, Gender.MALE),
                new Human("Ivanov", "Ilya", "Ivanovich", 1, Gender.MALE),
                new Human("Meganova", "Anita", "Ivanovna", 11, Gender.FEMALE)
        };

        return new Object[][]{
                {LambdaDemo.isYoungerFilter, HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[2], 0, false},
                {LambdaDemo.isYoungerFilter, HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[2], 2, false},
                {LambdaDemo.isYoungerFilter, HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[2], 12, false},
                {LambdaDemo.isYoungerFilter, HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[2], 20, false},
                {LambdaDemo.isYoungerFilter, HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[2], 21, true},
                {LambdaDemo.isYoungerFilter, HUMANS_FOR_TEST[0], HUMANS_FOR_TEST[1], HUMANS_FOR_TEST[2], 50, true}
        };
    }

    @Test(dataProvider = "runISpecialDataCheckerTestData")
    public void runISpecialDataCheckerTest(final ISpecialDataChecker<Human> checkerForTest,
                                           final Human humanForTest1,
                                           final Human humanForTest2,
                                           final Human humanForTest3,
                                           final int filter,
                                           final boolean expected
    ) {
        final boolean ACTUAL = run(checkerForTest, humanForTest1, humanForTest2, humanForTest3, filter);

        assertEquals(ACTUAL, expected);
    }
}