package ru.omsu.imit.javatasks.reflection;

import ru.omsu.imit.javatasks.collections.Human;
import ru.omsu.imit.javatasks.collections.Student;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class ReflectionDemo {
    public static int numberOfPeopleOnList(List<?> listForSearch) {
        return (int) listForSearch.stream()
                .filter(o -> o != null && (o.getClass() == Human.class || o.getClass() == Student.class))
                .count();
    }

    public static int numberPublicClassMethds(Object o) {
        return (int) Arrays.stream(o.getClass().getDeclaredMethods())
                .filter(method -> Modifier.isPublic(method.getModifiers()))
                .count();
    }
}