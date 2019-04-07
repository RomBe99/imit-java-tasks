package ru.omsu.imit.javatasks.collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionsDemo {
    public static int numberLinesStartingPerCharacter(final List<String> stringList, final char startChar) {
        int count = 0;

        for (String string : stringList) {
            if (string.charAt(0) == startChar) {
                count++;
            }
        }

        return count;
    }

    public static ArrayList<Human> findNamesakesFromList(final List<Human> listForSearch, final String surname) {
        ArrayList<Human> namesakesList = new ArrayList<>();

        for (Human human : listForSearch) {
            if (human.getSurname().equals(surname)) {
                namesakesList.add(human);
            }
        }

        return namesakesList;
    }
}
