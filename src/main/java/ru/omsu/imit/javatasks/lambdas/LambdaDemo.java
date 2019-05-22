package ru.omsu.imit.javatasks.lambdas;

import ru.omsu.imit.javatasks.lambdas.functionalinterfaceses.IBinaryObjectsChecker;
import ru.omsu.imit.javatasks.lambdas.functionalinterfaceses.ISpecialDataChecker;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaDemo {
    public static final Function<String, Integer> stringLength = String::length;
    public static final Function<String, Character> firstCharacter = s -> "".equals(s) ? null : s.charAt(0);
    public static final Predicate<String> notContainsSpaces = s -> s != null && !s.contains(" ");
    public static final Function<String, Integer> wordsCount = s -> "".equals(s) ? 0 : s.split(",").length;
    public static final Function<Human, Integer> getHumanAge = Human::getAge;
    public static final IBinaryObjectsChecker<Human> isNamesake = (h1, h2) -> h1.getSurname().equals(h2.getSurname());
    public static final Function<Human, String> getFullName = h -> h.getSurname() + h.getName() + h.getPatronymic();
    public static final UnaryOperator<Human> makeHumanOlder = h ->
            new Human(h.getSurname(), h.getName(), h.getPatronymic(), h.getAge() + 1, h.getSex());
    public static final ISpecialDataChecker<Human> isYoungerFilter = (h1, h2, h3, filter) ->
            filter > h1.getAge() && filter > h2.getAge() && filter > h3.getAge();
}