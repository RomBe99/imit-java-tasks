package ru.omsu.imit.javatasks.reflection;

import ru.omsu.imit.javatasks.collections.Human;
import ru.omsu.imit.javatasks.collections.Student;

import java.util.List;

public class ReflectionDemo {
    public static int numberOfPeopleOnList(List<?> listForSearch) {
        int count = 0;

        for (Object o : listForSearch) {
            if (o != null && (o.getClass() == Human.class || o.getClass() == Student.class)) {
                count++;
            }
        }

        return count;
    }
}
