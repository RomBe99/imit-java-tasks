package ru.omsu.imit.javatasks.payments;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static ru.omsu.imit.javatasks.payments.StringProcessor.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class StringProcessorTest {
    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {"N", 3, "NNN"},
                {"qwe", 3, "qweqweqwe"},
                {"", 3, ""},
                {"qwe", 0, ""},
                {"", 0, ""}
        };
    }

    @DataProvider
    public static Object[][] countData() {
        return new Object[][]{
                {"a", "a", 1},
                {"aa", "a", 2},
                {"aaa", "aa", 2},
                {"", "aaa", 0},
//                {"", "", 0},
//                    {"asdf", "", -1},
                {"aaaa", "vvv", 0},
                {"aeqra facwda", "a", 4}
        };
    }

    @DataProvider
    public static Object[][] onetwothreeData() {
        return new Object[][]{
                {"", ""},
                {"567890", "567890"},
                {" 1 ", " один "},
                {" 2", " два"},
                {"1 2 3", "один два три"}
        };
    }

    @DataProvider
    public static Object[][] changeWords() {
        return new Object[][]{
                {"", ""},
                {" qq ", " qq "},
                {"   123 erty 11 ", "   11 erty 123 "}
        };
    }

    @DataProvider
    public static Object[][] changeAge() {
        return new Object[][]{
                {"Васе 0x00000010 лет", "Васе 16 лет"},
                {"Васе 0x00000010 лет, Андрею 0x00000011 лет", "Васе 16 лет, Андрею 17 лет"},
                {"Васе 16 лет", "Васе 16 лет"}
        };
    }

    @Test(dataProvider = "data")
    public void testCopy(String str, int N, String expected) throws IllegalArgumentException, NullPointerException {
        assertEquals(stringMultiplier(str, N), expected);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testCopyExc() throws IllegalArgumentException {
        stringMultiplier("qwe", -6);
        fail();
    }

    @Test(dataProvider = "countData")
    public void testFind(String big, String small, int expected) {
        assertEquals(numberOfEnteriesToString(big, small), expected);
    }

    @Test(dataProvider = "onetwothreeData")
    public void testChange(String source, String expected) {
        assertEquals(replaceNumbersToWords(source), expected);
    }

    @Test
    public void testChange2() {
        StringBuilder stringBuilder = new StringBuilder("1234567");
        removeEverySecondChar(stringBuilder);
        assertEquals(stringBuilder.toString(), "1357");
        removeEverySecondChar(stringBuilder);
        assertEquals(stringBuilder.toString(), "15");
        removeEverySecondChar(stringBuilder);
        assertEquals(stringBuilder.toString(), "1");
        removeEverySecondChar(stringBuilder);
        assertEquals(stringBuilder.toString(), "1");
    }
}