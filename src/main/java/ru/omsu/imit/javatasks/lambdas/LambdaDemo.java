package ru.omsu.imit.javatasks.lambdas;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaDemo {
    public static Predicate<String> notContainsSpaces = string -> string != null && !string.contains(" ");
    public static UnaryOperator<Human> makeHumanOlder = human ->
            new Human(human.getSurname(), human.getName(), human.getPatronymic(), human.getAge() + 1, human.getSex());
}
