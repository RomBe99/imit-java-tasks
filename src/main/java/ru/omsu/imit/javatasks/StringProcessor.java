package ru.omsu.imit.javatasks;

public class StringProcessor {
    public static String stringMultiplier(String multiplicationString, int multiplicationNumber) throws IllegalArgumentException {
        if (multiplicationNumber < 0) {
            throw new IllegalArgumentException("Multiplication number < 0");
        }

        if (multiplicationString == null) {
            throw new NullPointerException("Multiplication string is null");
        }

        if (multiplicationNumber == 0) {
            return "";
        }

        if (multiplicationNumber == 1) {
            return multiplicationString;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < multiplicationNumber; i++) {
            sb.append(multiplicationString);
        }

        return sb.toString();
    }

    //todo Сломан (((
    public static int numberOfEnteriesToString(String str, String subStr) throws NullPointerException {
        if (str == null || subStr == null) {
            throw new NullPointerException();
        }

        if ("".equals(str)) {
            if ("".equals(subStr)) {
                return 1;
            }

            return 0;
        }

        if (str.equals(subStr)) {
            return 1;
        }

        int numberOfEntries = 0;

        for (int i = 0; i <= str.length() - subStr.length(); i++) {
            numberOfEntries++;
        }

        return numberOfEntries;
    }

    public static String replaceNumbersToWords(String stringToChange) throws NullPointerException {
        if (stringToChange == null) {
            throw new NullPointerException();
        }

        if ("".equals(stringToChange)) {
            return "";
        }

        if (!stringToChange.contains("1") && !stringToChange.contains("2") && !stringToChange.contains("3")) {
            return stringToChange;
        }

        StringBuilder sb = new StringBuilder();

        for (char character : stringToChange.toCharArray()) {
            switch (character) {
                case '1': {
                    sb.append("один");
                    break;
                }

                case '2': {
                    sb.append("два");
                    break;
                }

                case '3': {
                    sb.append("три");
                    break;
                }

                default: {
                    sb.append(character);
                    break;
                }
            }
        }

        return sb.toString();
    }

    public static void removeEverySecondChar(StringBuilder stringToModify) {
        for (int i = 1; i < stringToModify.length(); i++) {
            stringToModify.deleteCharAt(i);
        }
    }
}
