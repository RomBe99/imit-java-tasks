package ru.omsu.imit.javatasks.collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListAllDisjointSetsTest {
    private List<Set<Integer>> listWithIntSetsForTest;
    private Set<Integer> filterForTest;

    @Before
    public void setUp() {
        final int LIST_WITH_INT_SETS_FOR_TEST_SIZE = 5;
        final Integer[] VALUES_FOR_0_SET = {97, 17, 28, 64, 49};
        final Integer[] VALUES_FOR_1_SET = {69, 29, 25};
        final Integer[] VALUES_FOR_2_SET = {20, 5};
        final Integer[] VALUES_FOR_3_SET = {45};
        final Integer[] VALUES_FOR_4_SET = {90, 39, 4, 9, 67, 59, 33, 74};

        listWithIntSetsForTest = new ArrayList<>(LIST_WITH_INT_SETS_FOR_TEST_SIZE);
        listWithIntSetsForTest.add(new HashSet<>(Arrays.asList(VALUES_FOR_0_SET)));
        listWithIntSetsForTest.add(new HashSet<>(Arrays.asList(VALUES_FOR_1_SET)));
        listWithIntSetsForTest.add(new HashSet<>(Arrays.asList(VALUES_FOR_2_SET)));
        listWithIntSetsForTest.add(new HashSet<>(Arrays.asList(VALUES_FOR_3_SET)));
        listWithIntSetsForTest.add(new HashSet<>(Arrays.asList(VALUES_FOR_4_SET)));
    }

    @Test
    public void listAllDisjointSetsTest0() {
        List<Set<Integer>> ACTUAL = CollectionsDemo.listAllDisjointSets(new ArrayList<Set<Integer>>(), new HashSet<Integer>());

        Assert.assertNull(ACTUAL);
    }

    @Test
    public void listAllDisjointSetsTest1() {
        List<Set<Integer>> ACTUAL = CollectionsDemo.listAllDisjointSets(listWithIntSetsForTest, new HashSet<Integer>());

        Assert.assertNull(ACTUAL);
    }

    @Test
    public void listAllDisjointSetsTest3() {
        final Integer[] VALUES_FOR_FILTER = {97, 29, 5, 45, 90, 0};
        filterForTest = new HashSet<>(Arrays.asList(VALUES_FOR_FILTER));

        final int EXPECTED_SIZE = 0;
        final List<Set<Integer>> EXPECTED = new ArrayList<>();

        final List<Set<Integer>> ACTUAL = CollectionsDemo.listAllDisjointSets(listWithIntSetsForTest, filterForTest);

        assert ACTUAL != null;
        final int ACTUAL_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_SIZE, ACTUAL_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void listAllDisjointSetsTest4() {
        final Integer[] VALUES_FOR_FILTER = {97, 29, 5, 6, 90};
        filterForTest = new HashSet<>(Arrays.asList(VALUES_FOR_FILTER));

        final int EXPECTED_SIZE = 1;
        final List<Set<Integer>> EXPECTED = new ArrayList<>(EXPECTED_SIZE);
        EXPECTED.add(listWithIntSetsForTest.get(3));

        final List<Set<Integer>> ACTUAL = CollectionsDemo.listAllDisjointSets(listWithIntSetsForTest, filterForTest);

        assert ACTUAL != null;
        final int ACTUAL_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_SIZE, ACTUAL_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void listAllDisjointSetsTest5() {
        final Integer[] VALUES_FOR_FILTER = {9, 29, 7, 88, 32};
        filterForTest = new HashSet<>(Arrays.asList(VALUES_FOR_FILTER));

        final int EXPECTED_SIZE = 3;
        final List<Set<Integer>> EXPECTED = new ArrayList<>(EXPECTED_SIZE);
        EXPECTED.add(listWithIntSetsForTest.get(0));
        EXPECTED.add(listWithIntSetsForTest.get(2));
        EXPECTED.add(listWithIntSetsForTest.get(3));

        final List<Set<Integer>> ACTUAL = CollectionsDemo.listAllDisjointSets(listWithIntSetsForTest, filterForTest);

        assert ACTUAL != null;
        final int ACTUAL_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_SIZE, ACTUAL_SIZE);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }

    @Test
    public void listAllDisjointSetsTest6() {
        final Integer[] VALUES_FOR_FILTER = {55, 78, 22, 6, 32};
        filterForTest = new HashSet<>(Arrays.asList(VALUES_FOR_FILTER));

        final int EXPECTED_SIZE = listWithIntSetsForTest.size();

        final List<Set<Integer>> ACTUAL = CollectionsDemo.listAllDisjointSets(listWithIntSetsForTest, filterForTest);

        assert ACTUAL != null;
        final int ACTUAL_SIZE = ACTUAL.size();

        Assert.assertEquals(EXPECTED_SIZE, ACTUAL_SIZE);
        Assert.assertEquals(listWithIntSetsForTest, ACTUAL);
    }
}