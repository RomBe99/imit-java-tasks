package ru.omsu.imit.javatasks.lambdas.functionalinterfaceses;

@FunctionalInterface
public interface IBinaryObjectsChecker<T> {
    boolean check(T t1, T t2);
}