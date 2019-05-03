package ru.omsu.imit.javatasks.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        List<Human> namesakesList = new ArrayList<>();

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

        List<Human> newList = new ArrayList<>(listForDeleteHuman);

        for (int i = 0; i < SIZE; i++) {
            if (humanForDelete.equals(listForDeleteHuman.get(i))) {
                newList.remove(i);
                break;
            }
        }

        return newList;
    }

    public static List<Set<Integer>> listAllDisjointSets(final List<Set<Integer>> listWithIntSets, final Set<Integer> filter) {
        if (listWithIntSets.isEmpty() || filter.isEmpty()) {
            return null;
        }

        List<Set<Integer>> newList = new ArrayList<>();
        boolean isNotContains;

        for (Set<Integer> s : listWithIntSets) {
            isNotContains = true;

            for (int i : s) {
                if (filter.contains(i)) {
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

        Set<Human> humansWithMaxAge = new HashSet<>();

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

        if (filter.isEmpty()) {
            return new HashSet<>(mapForFiltering.values());
        }

        Set<Integer> mapForFilteringKeySet = mapForFiltering.keySet();
        boolean isNotContains = true;

        for (int i : filter) {
            if (mapForFilteringKeySet.contains(i)) {
                isNotContains = false;
                break;
            }
        }

        if (isNotContains) {
            return null;
        }

        Set<Human> newHashSet = new HashSet<>();

        for (int i : filter) {
            newHashSet.add(mapForFiltering.get(i));
        }

        return newHashSet;
    }

    public static List<Integer> humansMoreEighteensYearsOld(final Map<Integer, Human> humanMap) {
        if (humanMap.isEmpty()) {
            return null;
        }

        final int AGE = 18;

        List<Integer> keys = new ArrayList<>();

        for (Map.Entry<Integer, Human> e : humanMap.entrySet()) {
            if (e.getValue().getAge() >= AGE) {
                keys.add(e.getKey());
            }
        }

        return keys;
    }

    public static Map<Integer, Integer> idToAge(final Map<Integer, Human> humanMap, final Set<Integer> filter) {
        if (humanMap.isEmpty()) {
            return null;
        }

        Map<Integer, Integer> newImage = new HashMap<>();

        if (filter.isEmpty()) {
            return newImage;
        }

        for (Integer i : filter) {
            if (humanMap.containsKey(i)) {
                newImage.put(i, humanMap.get(i).getAge());
            }
        }

        return newImage;
    }

    public static Map<Integer, List<Human>> sortToAge(final Set<Human> humans) {
        if (humans.isEmpty()) {
            return null;
        }

        Map<Integer, List<Human>> newImage = new HashMap<>();
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