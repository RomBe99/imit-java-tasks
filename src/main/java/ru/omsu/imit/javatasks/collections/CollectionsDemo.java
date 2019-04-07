package ru.omsu.imit.javatasks.collections;

import java.util.List;

public class CollectionsDemo {
    public static int numberLinesStartingPerCharacter(List<String> stringList, char startChar) {
        int count = 0;

        for (String string : stringList) {
            if (string.charAt(0) == startChar) {
                count++;
            }
        }

        return count;
    }
}
