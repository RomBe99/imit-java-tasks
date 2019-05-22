package ru.omsu.imit.javatasks.reflection;

import ru.omsu.imit.javatasks.collections.Human;
import ru.omsu.imit.javatasks.collections.Student;

import java.util.List;

public class ReflectionDemo {
    public static int numberOfPeopleOnList(List<?> listForSearch) {
        return (int) listForSearch.stream()
                .filter(o -> o != null && (o.getClass() == Human.class || o.getClass() == Student.class))
                .count();
    }
}
