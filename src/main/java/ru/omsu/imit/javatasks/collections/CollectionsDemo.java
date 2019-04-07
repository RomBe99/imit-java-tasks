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
            if (surname.equals(human.getSurname())) {
                namesakesList.add(human);
            }
        }

        return namesakesList;
    }

    public static ArrayList<Human> deleteHumanFromList(final List<Human> listForDeleteHuman, final Human humanForDelete) {
        if (!listForDeleteHuman.contains(humanForDelete)) {
            return new ArrayList<>(listForDeleteHuman);
        }

        final int SIZE = listForDeleteHuman.size();

        ArrayList<Human> newList = new ArrayList<>(listForDeleteHuman);

        for (int i = 0; i < SIZE; i++) {
            if (humanForDelete.equals(listForDeleteHuman.get(i))) {
                newList.remove(i);
                break;
            }
        }

        return newList;
    }
}