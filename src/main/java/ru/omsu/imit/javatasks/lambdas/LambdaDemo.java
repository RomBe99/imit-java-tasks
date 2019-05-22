package ru.omsu.imit.javatasks.lambdas;

import java.util.function.Predicate;

public class LambdaDemo {
    public static Predicate<String> notContainsSpaces = string -> string != null && !string.contains(" ");
}
