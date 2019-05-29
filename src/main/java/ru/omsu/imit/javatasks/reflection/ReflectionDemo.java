package ru.omsu.imit.javatasks.reflection;

import ru.omsu.imit.javatasks.collections.Human;
import ru.omsu.imit.javatasks.collections.Student;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ReflectionDemo {
    public static long numberOfPeopleOnList(final List<Object> listForSearch) {
        return listForSearch.stream()
                .filter(o -> o != null && Human.class.isAssignableFrom(o.getClass()))
                .count();
    }

    public static List<String> getListNamesPublicClassMethods(final Object o) {
        List<String> listNamesPublicClassMethods = new ArrayList<>();

        Arrays.stream(o.getClass().getDeclaredMethods())
                .filter(m -> Modifier.isPublic(m.getModifiers()))
                .forEach(m -> listNamesPublicClassMethods.add(m.getName()));

        return listNamesPublicClassMethods;
    }

    public static List<String> objectSuperclassList(final Object object) {
        List<String> objectSuperclassList = new ArrayList<>();
        Class temp = object.getClass().getSuperclass();

        while (temp != null) {
            objectSuperclassList.add(temp.toString());
            temp = temp.getSuperclass();
        }

        return objectSuperclassList;
    }

    public static long executableRunner(final List<?> listForSearch) {
        return listForSearch.stream()
                .filter(o -> o instanceof Executable)
                .peek(exec -> ((Executable) exec).execute())
                .count();
    }

    public static List<String> objectGettersAndSetters(Object object) {
        List<String> listForGettersAndSetters = new ArrayList<>();

        final Predicate<Method> isGetter = m ->
                Modifier.isPublic(m.getModifiers()) && !Modifier.isStatic(m.getModifiers()) &&
                        m.getReturnType() != Void.TYPE &&
                        m.getName().startsWith("get") && m.getParameterCount() == 0;

        final Predicate<Method> isSetter = m ->
                Modifier.isPublic(m.getModifiers()) && !Modifier.isStatic(m.getModifiers()) &&
                        m.getReturnType() == Void.TYPE &&
                        m.getName().startsWith("set") && m.getParameterCount() != 0;

        Arrays.stream(object.getClass().getDeclaredMethods())
                .filter(m -> Modifier.isPublic(m.getModifiers()))
                .filter(m -> isGetter.test(m) || isSetter.test(m)).
                forEach(m -> listForGettersAndSetters.add(m.getName()));

        return listForGettersAndSetters;
    }
}