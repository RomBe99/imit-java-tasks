package ru.omsu.imit.javatasks.collections;

import java.util.*;

public class CollectionsDemo {
    public static int numberLinesStartingPerCharacter(final List<String> stringList, final char startChar) {
        if (stringList.isEmpty()) {
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

    public static List<Human> findNamesakesFromList(final List<Human> listForSearch, final Human namesake) {
        if (listForSearch.isEmpty()) {
            return null;
        }

        final String NAMESAKE_SURNAME = namesake.getSurname();
        ArrayList<Human> namesakesList = new ArrayList<>();

        for (Human human : listForSearch) {
            if (NAMESAKE_SURNAME.equals(human.getSurname())) {
                namesakesList.add(human);
            }
        }

        return namesakesList;
    }

    public static List<Human> deleteHumanFromList(final List<Human> listForDeleteHuman, final Human humanForDelete) {
        if (listForDeleteHuman.isEmpty()) {
            return null;
        }

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

    public static List<Set<Integer>> listAllDisjointSets(final List<Set<Integer>> setList, final Set<Integer> set) {
        if (setList.isEmpty() || set.isEmpty()) {
            return null;
        }

        ArrayList<Set<Integer>> newList = new ArrayList<>();
        boolean isNotContains = true;

        for (Set<Integer> s : setList) {
            for (int i : s) {
                if (set.contains(i)) {
                    isNotContains = false;
                    break;
                }
            }

            if (isNotContains) {
                newList.add(s);
            }
        }

        return newList;
    }

    public static Set<Human> maxAge(final List<Human> humanList) {
        if (humanList.isEmpty()) {
            return null;
        }

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

    public static Set<Human> humanFilter(final Map<Integer, Human> mapForFiltering, final Set<Integer> filter) {
        if (mapForFiltering.isEmpty()) {
            return null;
        }

        Set<Integer> temp = mapForFiltering.keySet();

        if (temp.retainAll(filter)) {
            return null;
        }

        HashSet<Human> newHashSet = new HashSet<>();

        for (Integer i : temp) {
            newHashSet.add(mapForFiltering.get(i));
        }

        return newHashSet;
    }

    public static List<Integer> humansMoreEighteensYearsOld(final Map<Integer, Human> humanMap) {
        if (humanMap.isEmpty()) {
            return null;
        }

        final int SIZE = humanMap.size();
        final int AGE = 18;

        ArrayList<Integer> keys = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            if (humanMap.get(i).getAge() >= AGE) {
                keys.add(i);
            }
        }

        return keys;
    }

    public static Map<Integer, Integer> idToAge(final Map<Integer, Human> humanMap, final Set<Integer> filter) {
        if (humanMap.isEmpty()) {
            return null;
        }

        HashMap<Integer, Integer> newImage = new HashMap<>();

        for (Integer i : filter) {
            newImage.put(i, humanMap.get(i).getAge());
        }

        return newImage;
    }

    public static Map<Integer, ArrayList<Human>> sortToAge(final Set<Human> humans) {
        if (humans.isEmpty()) {
            return null;
        }

        HashMap<Integer, ArrayList<Human>> newImage = new HashMap<>();
        int temp;

        for (Human h : humans) {
            temp = h.getAge();

            if (!newImage.containsKey(temp)) {
                newImage.put(temp, new ArrayList<Human>());
            }

            newImage.get(temp).add(h);
        }

        return newImage;
    }
}