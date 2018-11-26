public class StringProcessor {
    public static String stringMultiplier(String multiplicationString, int multiplicationNumber) throws Exception {
        if (multiplicationNumber < 0) {
            throw new Exception("Multiplication number < 0");
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

        int numberOfEntries = 0;

        for (int i = 0; i >= 0; i = str.indexOf(subStr, i)) {
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
                    sb.append("one");
                }

                case '2': {
                    sb.append("two");
                }

                case '3': {
                    sb.append("three");
                }

                default: {
                    sb.append(character);
                }
            }
        }

        return sb.toString();
    }

    public static void removeEverySecondChar(StringBuilder stringToModify) {
        for (int i = 0; i < stringToModify.length() / 2; i=+2) {
            stringToModify.deleteCharAt(i);
        }
    }
}
