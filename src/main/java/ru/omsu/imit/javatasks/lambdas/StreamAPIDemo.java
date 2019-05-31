package ru.omsu.imit.javatasks.lambdas;

import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class StreamAPIDemo extends LambdaDemo {
    public final static UnaryOperator<List<?>>  deleteNullsFromObjectList = l -> l.stream().
            filter(Objects::nonNull).collect(Collectors.toList());
    public final static Function<Set<Integer>, Long> countPositiveNumbers = s -> s.stream().
            filter(i -> i >= 0).count();
    public final static Function<List<?>, Object[]> threeLastObjects = l -> l.stream().
            skip((long) l.size() - 3).toArray();
    public final static Function<List<Integer>, Integer> firstEvenNumber = l -> l.stream().
            filter(i -> i % 2 == 0).findFirst().orElse(null);
    public final static Function<Integer[], List<Integer>> squareWithoutRepeat = ints -> Arrays.stream(ints).
        distinct().map(i -> i * i).collect(Collectors.toList());
    public final static UnaryOperator<List<String>> allNotEmptyStrings = l -> l.stream().
            filter(s -> s != null && !"".equals(s)).collect(Collectors.toList());
}