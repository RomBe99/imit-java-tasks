package ru.omsu.imit.javatasks.lambdas;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class StreamAPIDemo extends LambdaDemo {
    public final static UnaryOperator<List<?>>  deleteNullsFromObjectList = l -> l.stream().
            filter(Objects::nonNull).collect(Collectors.toList());
    public final static Function<Set<Integer>, Long> countPositiveNumbers = s -> s.stream().
            filter(i -> i >= 0).count();
}