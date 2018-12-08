package ru.omsu.imit.javatasks.payments;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PaymentTest {
    private Payment payment;
    private final String fullName = "Belinsky Roman Grigorevich";
    private final byte day = 1;
    private final byte month = 12;
    private final int year = 2008;
    private final int amountOfPayment = 559;

    @Before
    public void setUp() throws Exception {
        payment = new Payment(fullName, day, month, year, amountOfPayment);
    }

    @Test
    public void testGetters() {
        Assert.assertEquals(payment.getFullName(), fullName);
        Assert.assertEquals(payment.getDay(), day);
        Assert.assertEquals(payment.getMonth(), month);
        Assert.assertEquals(payment.getYear(), year);
        Assert.assertEquals(payment.getAmountOfPayment(), amountOfPayment);
    }

    @Test
    public void testSetters() {
        final String newFullName = "Gorkun Ilya Fedorovich";
        payment.setFullName(newFullName);
        Assert.assertEquals(payment.getFullName(), newFullName);

        final byte newDay = 1;
        payment.setDay(newDay);
        Assert.assertEquals(payment.getDay(), newDay);

        final byte newMonth = 12;
        payment.setMonth(newMonth);
        Assert.assertEquals(payment.getMonth(), newMonth);

        final int newYear = 2008;
        payment.setYear(newYear);
        Assert.assertEquals(payment.getYear(), newYear);

        final int newAmountOfPayment = 559;
        payment.setAmountOfPayment(newAmountOfPayment);
        Assert.assertEquals(payment.getAmountOfPayment(), newAmountOfPayment);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() {
        int count = 0;

        byte newDay = 0;

        try {
            payment.setDay(newDay);
        } catch (IllegalArgumentException e) {
            count++;
        }

        newDay = 32;

        try {
            payment.setDay(newDay);
        } catch (IllegalArgumentException e) {
            count++;
        }

        byte newMonth = 0;

        try {
            payment.setMonth(newMonth);
        } catch (IllegalArgumentException e) {
            count++;
        }

        newMonth = 13;

        try {
            payment.setMonth(newMonth);
        } catch (IllegalArgumentException e) {
            count++;
        }

        int newYear = 1800;

        try {
            payment.setYear(newYear);
        } catch (IllegalArgumentException e) {
            count++;
        }

        newYear = 2020;

        try {
            payment.setYear(newYear);
        } catch (IllegalArgumentException e) {
            count++;
        }

        final int newAmountOfPayment = 0;

        try {
            payment.setAmountOfPayment(newAmountOfPayment);
        } catch (IllegalArgumentException e) {
            count++;
        }

        if (count == 7) {
            throw new IllegalArgumentException();
        }
    }

    @Test (expected = NullPointerException.class)
    public void testNullPointerException() {
        payment.setFullName(null);
    }
}
