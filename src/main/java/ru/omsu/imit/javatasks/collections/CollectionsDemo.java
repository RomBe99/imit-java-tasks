package ru.omsu.imit.javatasks.collections;

import java.util.*;

public class CollectionsDemo {
    public static int numberLinesStartingPerCharacter(final List<String> stringList, final char startChar) {
        if (stringList.size() == 0) {
            return 0;
        }

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

    public static ArrayList<Set<Integer>> listAllDisjointSets(List<Set<Integer>> setList, Set<Integer> set) {
        if (setList.size() == 0 || set.size() == 0) {
            return null;
        }

        ArrayList<Set<Integer>> newList = new ArrayList<>();

        for (Set<Integer> s : setList) {
            if (!s.retainAll(set)) {
                newList.add(s);
            }
        }

        return newList;
    }

    public static HashSet<Human> maxAge(final List<Human> humanList) {
        HashSet<Human> humansWithMaxAge = new HashSet<>();
        int maxAge = 0;
        int temp;

        for (Human h : humanList) {
            temp = h.getAge();

            if (temp >= maxAge) {
                maxAge = temp;
            }
        }

        for (Human h : humanList) {
            temp = h.getAge();

            if (temp == maxAge) {
                humansWithMaxAge.add(h);
            }
        }

        return humansWithMaxAge;
    }

    public static HashSet<Human> humanFilter(final Map<Integer, Human> mapForFiltering, final Set<Integer> filter) {
        Set<Integer> temp = mapForFiltering.keySet();

        if (!temp.retainAll(filter)) {
            return null;
        }

        HashSet<Human> newHashSet = new HashSet<>();

        for (Integer i : temp) {
            newHashSet.add(mapForFiltering.get(i));
        }

        return newHashSet;
    }
}