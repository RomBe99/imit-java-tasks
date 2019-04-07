package ru.omsu.imit.javatasks.collections;

import org.junit.Before;

import java.util.ArrayList;

public class CollectionsDemoTest {
    private ArrayList<String> stringArrayList;

    @Before
    public void setUp() {
        final int ARRAY_LIST_SIZE = 10;

        stringArrayList = new ArrayList<>(ARRAY_LIST_SIZE);

    }
}
