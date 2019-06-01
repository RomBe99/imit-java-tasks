package ru.omsu.imit.javatasks.lambdas;

import ru.omsu.imit.javatasks.lambdas.functionalinterfaceses.IBinaryObjectsChecker;
import ru.omsu.imit.javatasks.lambdas.functionalinterfaceses.ISpecialDataChecker;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaRunner {
    public static <T, R> R run(final Function<T, R> lambda, final T arg) {
        return lambda.apply(arg);
    }

    public static <T> boolean run(final Predicate<T> lambda, final T s) {
        return lambda.test(s);
    }

    public static <T> boolean run(final IBinaryObjectsChecker<T> c, final T h1, final T h2) {
        return c.check(h1, h2);
    }

    public static <T> T run(final UnaryOperator<T> uo, final T h) {
        return uo.apply(h);
    }

    public static <T> boolean run(
            final ISpecialDataChecker<T> c,
            final T h1, final T h2, final T h3,
            final int filter
    ) {
        return c.specialDataChecker(h1, h2, h3, filter);
    }
}