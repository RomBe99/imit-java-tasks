package ru.omsu.imit.javatasks.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {

    /**
     * Задание 1 ++
     * Вернуть количество строк входного списка строк начинающегося с заданного символа.
     *
     * @param stringList список строк.
     * @param startChar первый символ.
     * @return количество строк входного списка, у которых первый символ совпадает с заданным.
     */
    public static int numberLinesStartingPerCharacter(final List<String> stringList, final char startChar) {
        if (stringList.isEmpty()) {
            return 0;
        }

        int count = 0;

        for (String s : stringList) {
            if (s != null && !("".equals(s)) && s.charAt(0) == startChar) {
                count++;
            }
        }

        return count;
    }

    /**
     * Задание 2
     * Из входного списка объектов типа Human сформировать список однофомильцев заданного объекта типа Human.
     *
     * @param listForSearch список объектов типа Human.
     * @param namesake объект типа Human.
     * @return список однофамильцев заданного человека среди людей из входного списка.
     */
    public static List<Human> findNamesakesFromList(final List<Human> listForSearch, final Human namesake) {
        if (listForSearch.isEmpty()) {
            return new ArrayList<>();
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

    /**
     * Задание 3 ++
     * На вход подаётся список Human из него необходимо удалить заданного человека (при изменении элементов
     * входного списка элементы выходного изменяться не должны).
     *
     * @param listForDeleteHuman список объектов из которого нужно удалить заданного человека.
     * @param humanForDelete человек для удаления.
     * @return копия
     * входного списка, не содержащая выделенного человека.
     */
    public static List<Human> deleteHumanFromList(final List<Human> listForDeleteHuman, final Human humanForDelete) {
        if (listForDeleteHuman.isEmpty()) {
            return new ArrayList<>();
        }

        if (!listForDeleteHuman.contains(humanForDelete) || humanForDelete == null) {
            return new ArrayList<>(listForDeleteHuman);
        }

        List<Human> newList = new ArrayList<>();

        for (Human h : listForDeleteHuman) {
            if (!humanForDelete.equals(h)) {
                newList.add(h);
            }
        }

        return newList;
    }

    /**
     * Задание 4
     * Найти список всех множеств входного списка, которые не пересекаются с заданным множеством.
     *
     * @param listWithIntSets список множеств целых чисел.
     * @param filter заданное множество для фильрации.
     * @return список всех множеств
     * входного списка, которые не пересекаются с заданным множеством.
     */
    public static List<Set<Integer>> listAllDisjointSets(final List<Set<Integer>> listWithIntSets, final Set<Integer> filter) {
        if (listWithIntSets.isEmpty() || filter.isEmpty()) {
            return new ArrayList<>();
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

    /**
     * Задание 5
     * Создайте класс Student, производный от Human, новое поле — название факультета,
     * к нему геттер, сеттер и конструктор. Найти множество людей из входного списка с максимальным возрастом.
     *
     * @param humanList список, состоящий из
     * объектов типа Human и его производных классов.
     * @return множество людей из
     * входного списка с максимальным возрастом.
     */
    public static Set<Human> maxAge(final List<Human> humanList) {
        if (humanList.isEmpty()) {
            return new HashSet<>();
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

    /**
     * Задание 7
     *  Найти множество людей идентификаторы которых содеражаться во входном множестве.
     *
     * @param mapForFiltering набор людей, каждому человеку задан уникальный целочисленный идентификатор.
     * @param filter множество целых чисел для фильтрации.
     * @return множество людей, идентификаторы которых содержатся во входном
     * множестве.
     */
    public static Set<Human> humanFilter(final Map<Integer, Human> mapForFiltering, final Set<Integer> filter) {
        if (mapForFiltering.isEmpty()) {
            return new HashSet<>();
        }

        if (filter.isEmpty()) {
            return new HashSet<>(mapForFiltering.values());
        }

        Set<Human> newHashSet = new HashSet<>();

        for (int i : filter) {
            newHashSet.add(mapForFiltering.get(i));
        }

        return newHashSet;
    }

    /**
     * Задание 8
     * Из отображения предыдущей задачи построить список идентификаторов людей, чей возраст не
     * менее 18 лет.
     *
     * @param humanMap набор людей, каждому человеку задан уникальный целочисленный идентификатор.
     * @return список идентификаторов людей, чей возраст не менее 18 лет.
     */
    public static List<Integer> humansMoreEighteensYearsOld(final Map<Integer, Human> humanMap) {
        if (humanMap.isEmpty()) {
            return new ArrayList<>();
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

    /**
     * Задание 9 --
     * Из отображения предыдущей задачи построить новое отображение, которое идентификатору возраста
     * споставляет возраст человека.
     *
     * @param humanMap набор людей, каждому человеку задан уникальный целочисленный идентификатор.
     * @param filter множество идентификаторов для фильтрации.
     * @return отображение номеров людей из входного множества -> возвраст людей, которые ключи которых содеражться
     * во входном множестве.
     */
    public static Map<Integer, Integer> idToAge(final Map<Integer, Human> humanMap, final Set<Integer> filter) {
        if (humanMap.isEmpty()) {
            return new HashMap<>();
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

    /**
     * Задание 10
     * По множеству объектов типа Human постройте отображение, которое целому числу
     * (возраст человека) сопоставляет список всех людей данного возраста из входного множества.
     *
     * @param humans множество объектов для построения отображения.
     * @return список всех людей данного возраста из входного
     * множества.
     */
    public static Map<Integer, List<Human>> sortToAge(final Set<Human> humans) {
        if (humans.isEmpty()) {
            return new HashMap<>();
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