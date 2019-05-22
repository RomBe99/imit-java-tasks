package ru.omsu.imit.javatasks.lambdas.functionalinterfaceses;

@FunctionalInterface
public interface ISpecialDataChecker<T> {
    boolean specialDataChecker(T t1, T t2, T t3, int filter);
}
