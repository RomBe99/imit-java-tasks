package ru.omsu.imit.javatasks.collections;

import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionsDemoTest {
    private ArrayList<String> stringArrayList;

    @Before
    public void setUp() {
        final String[] STRINGS = {"John", "Ken", "Oscar", "Jasmine", "Olivia", "Ollie", "Kai", "Victoria", "Jessica", "Oliver"};

        stringArrayList = new ArrayList<>(Arrays.asList(STRINGS));
    }
}
