package ru.omsu.imit.javatasks.functions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegralTest {
    private Integral integral;
    private final double DELTA = 0.01;

    @Before
    public void setUp() throws FunctionalException {
        integral = new Integral(4, 0);
    }
}