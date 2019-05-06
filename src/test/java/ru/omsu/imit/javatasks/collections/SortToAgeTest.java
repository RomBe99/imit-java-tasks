package ru.omsu.imit.javatasks.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortToAgeTest {
    private Set<Human> humansForTest;

    @Test
    public void sortToAgeTest0() {
        Assert.assertEquals(new HashMap<Integer, List<Human>>(), CollectionsDemo.sortToAge(new HashSet<Human>()));
    }

    @Test
    public void sortToAgeTest1() {
        final int EXPECTED_MAP_SIZE = 1;
        final int HUMAN_FOR_TEST_SIZE = 1;

        final List<Human> HUMANS = new ArrayList<>(HUMAN_FOR_TEST_SIZE);
        HUMANS.add(new Human("Ivanov","Ivan", "Ivanovich", 20));

        final HashMap<Integer, List<Human>> EXPECTED = new HashMap<>(EXPECTED_MAP_SIZE);
        EXPECTED.put(HUMANS.get(0).getAge(), HUMANS);

        humansForTest = new HashSet<>(HUMANS);

        final Map<Integer, List<Human>> ACTUAL = CollectionsDemo.sortToAge(humansForTest);

        assert ACTUAL != null;
        final int ACTUAL_MAP_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_MAP_SIZE, ACTUAL_MAP_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void sortToAgeTest2() {
        final int EXPECTED_MAP_SIZE = 3;
        final int HUMAN_FOR_TEST_SIZE = 10;

        final List<Human> HUMANS = new ArrayList<>(HUMAN_FOR_TEST_SIZE);
        HUMANS.add(new Human("Ivanov","Ivan", "Ivanovich", 20));
        HUMANS.add(new Human("Romanov","Roman", "Romanovich", 10));
        HUMANS.add(new Human("Igorev","Igor", "Igorevich", 30));
        HUMANS.add(new Human("Egorov","Egor", "Egorovich", 20));
        HUMANS.add(new Human("Nikitin","Nikita", "Nikitoich", 10));
        HUMANS.add(new Human("Danilov","Danil", "Danilovich", 10));
        HUMANS.add(new Human("Petrov","Petr", "Petrovich", 30));
        HUMANS.add(new Human("Konstantinov","Konstantin", "Konstantinovich", 20));
        HUMANS.add(new Human("Denisov","Denis", "Denisovich", 30));
        HUMANS.add(new Human("Alexandrov","Alexandr", "Alexanrovich", 30));

        final HashMap<Integer, List<Human>> EXPECTED = new HashMap<>(EXPECTED_MAP_SIZE);
        EXPECTED.put(10, new ArrayList<Human>(3));
        EXPECTED.put(20, new ArrayList<Human>(3));
        EXPECTED.put(30, new ArrayList<Human>(4));

        EXPECTED.get(10).add(HUMANS.get(4));
        EXPECTED.get(10).add(HUMANS.get(5));
        EXPECTED.get(10).add(HUMANS.get(1));

        EXPECTED.get(20).add(HUMANS.get(3));
        EXPECTED.get(20).add(HUMANS.get(0));
        EXPECTED.get(20).add(HUMANS.get(7));

        EXPECTED.get(30).add(HUMANS.get(9));
        EXPECTED.get(30).add(HUMANS.get(8));
        EXPECTED.get(30).add(HUMANS.get(2));
        EXPECTED.get(30).add(HUMANS.get(6));

        humansForTest = new HashSet<>(HUMANS);

        final Map<Integer, List<Human>> ACTUAL = CollectionsDemo.sortToAge(humansForTest);

        assert ACTUAL != null;
        final int ACTUAL_MAP_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_MAP_SIZE, ACTUAL_MAP_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }
}