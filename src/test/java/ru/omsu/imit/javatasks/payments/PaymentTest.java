package ru.omsu.imit.javatasks.payments;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PaymentTest {
    private Payment payment;
    private String fullName = "Belinsky Roman Grigorevich";
    private byte day = 1;
    private byte month = 12;
    private int year = 2008;
    private int amountOfPayment = 559;

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
        fullName = "Gorkun Ilya Fedorovich";
        payment.setFullName(fullName);
        Assert.assertEquals(payment.getFullName(), fullName);

        day = 1;
        payment.setDay(day);
        Assert.assertEquals(payment.getDay(), day);

        month = 12;
        payment.setMonth(month);
        Assert.assertEquals(payment.getMonth(), month);

        year = 2008;
        payment.setYear(year);
        Assert.assertEquals(payment.getYear(), year);

        amountOfPayment = 559;
        payment.setAmountOfPayment(amountOfPayment);
        Assert.assertEquals(payment.getAmountOfPayment(), amountOfPayment);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() {
        int count = 0;

        day = 0;

        try {
            payment.setDay(day);
        } catch (IllegalArgumentException e) {
            count++;
        }

        day = 32;

        try {
            payment.setDay(day);
        } catch (IllegalArgumentException e) {
            count++;
        }

        month = 0;

        try {
            payment.setMonth(month);
        } catch (IllegalArgumentException e) {
            count++;
        }

        month = 13;

        try {
            payment.setMonth(month);
        } catch (IllegalArgumentException e) {
            count++;
        }

        year = 1800;

        try {
            payment.setYear(year);
        } catch (IllegalArgumentException e) {
            count++;
        }

        year = 2020;

        try {
            payment.setYear(year);
        } catch (IllegalArgumentException e) {
            count++;
        }

        amountOfPayment = 0;

        try {
            payment.setAmountOfPayment(amountOfPayment);
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
