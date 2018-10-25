package october2018;

public class StringProcessor {
    public static String stringMultiplier(String multiplicationString, int multiplicationNumber) throws Exception {
        if (multiplicationNumber < 0) {
            throw new Exception("Multiplication number < 0");
        }

        if (multiplicationString == null) {
            throw new Exception("Multiplication string is null");
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
}
