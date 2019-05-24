package ru.omsu.imit.javatasks.lambdas;

import ru.omsu.imit.javatasks.lambdas.functionalinterfaceses.IBinaryObjectsChecker;
import ru.omsu.imit.javatasks.lambdas.functionalinterfaceses.ISpecialDataChecker;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaRunner {
    public static Integer runFunctionsSI(final Function<String, Integer> f, final String s) {
        return f.apply(s);
    }

    public static Character runFunctionSC(final Function<String, Character> f, final String s) {
        return f.apply(s);
    }

    public static boolean runPredicateS(final Predicate<String> p, final String s) {
        return p.test(s);
    }

    public static Integer runFunctionsHI(final Function<Human, Integer> f, final Human h) {
        return f.apply(h);
    }

    public static boolean runIBinaryObjectsChecker(final IBinaryObjectsChecker<Human> c, final Human h1, final Human h2) {
        return c.check(h1, h2);
    }

    public static String runFunctionsHS(final Function<Human, String> f, final Human h) {
        return f.apply(h);
    }

    public static Human runUnaryOperatorH(final UnaryOperator<Human> uo, final Human h) {
        return uo.apply(h);
    }

    public static boolean runISpecialDataChecker(final ISpecialDataChecker<Human> c,
                                                 final Human h1, final Human h2, final Human h3, final int filter) {
        return c.specialDataChecker(h1, h2, h3, filter);
    }
}