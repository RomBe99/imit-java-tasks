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
}
