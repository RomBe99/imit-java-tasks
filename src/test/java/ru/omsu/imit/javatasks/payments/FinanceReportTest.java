package ru.omsu.imit.javatasks.payments;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FinanceReportTest {
    private FinanceReport financeReport;

    @Before
    public void setUp() {
        Payment payment1 = new Payment("Lovelace Ivan Ivanvich", (byte) 22, (byte) 11, 1999, 228);
        Payment payment2 = new Payment("Neyman Ivan Ivanvich", (byte) 11, (byte) 5, 2010, 200);
        Payment payment3 = new Payment("Babbage Ivan Ivanvich", (byte) 1, (byte) 1, 2015, 1337);
        Payment payment4 = new Payment("Leibniz Ivan Ivanvich", (byte) 3, (byte) 3, 1922, 223);
        Payment payment5 = new Payment("Newton Ivan Ivanvich", (byte) 5, (byte) 4, 2012, 23);
        Payment payment6 = new Payment("Gauss Ivan Ivanvich", (byte) 7, (byte) 2, 2002, 133);

        financeReport = new FinanceReport(payment1, payment2, payment3, payment4, payment5, payment6);
    }

    @Test (expected = NullPointerException.class)
    public void nullPaymentsArrayTest() throws NullPointerException {
        Payment[] nullPayments = null;
        FinanceReport fr = new FinanceReport(nullPayments);
    }

    @Test
    public void copyConstructorTest() {
        Assert.assertSame(new FinanceReport(financeReport).getPayments(), financeReport.getPayments());
    }

    @Test (expected = NullPointerException.class)
    public void nullElementPaymentsArrayTest() throws NullPointerException {
        Payment payment1 = new Payment("Lovelace Ivan Ivanvich", (byte) 22, (byte) 11, 1999, 228);
        Payment nullPayment = null;
        Payment payment2 = new Payment("Neyman Ivan Ivanvich", (byte) 11, (byte) 5, 2010, 200);
        Payment payment3 = new Payment("Babbage Ivan Ivanvich", (byte) 1, (byte) 1, 2015, 1337);

        FinanceReport fr = new FinanceReport(payment1, nullPayment, payment2, payment3);
    }

    @Test
    public void setPaymentTest() {
        Payment newPayment = new Payment("Lovelace Ivan Ivanvich", (byte) 22, (byte) 11, 1999, 228);
        financeReport.setPayment(newPayment, 0);
        Assert.assertEquals(financeReport.getPayment(0), newPayment);
    }

    @Test (expected = NullPointerException.class)
    public void setPaymentNullPointerExceptionTest() {
        Payment newPayment = null;
        financeReport.setPayment(newPayment, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getPaymentIllegalArgumentException1Test() {
        financeReport.getPayment(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getPaymentIllegalArgumentException2Test() {
        financeReport.getPayment(55);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setPaymentIllegalArgumentException1Test() {
        financeReport.setPayment(new Payment("Lovelace Ivan Ivanvich", (byte) 22, (byte) 11, 1999, 228), -1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setPaymentIllegalArgumentException2Test() {
        financeReport.setPayment(new Payment("Lovelace Ivan Ivanvich", (byte) 22, (byte) 11, 1999, 228), 55);
    }

    @Test
    public void outputLastNamesTest() {
        Assert.assertEquals(financeReport.outputLastNames('n'), financeReport.getPayment(1).toString() + financeReport.getPayment(4).toString());
        Assert.assertEquals(financeReport.outputLastNames('B'), financeReport.getPayment(2).toString());
    }

    @Test
    public void outputLastNamesWrongFirstLetterTest() {
        Assert.assertEquals(financeReport.outputLastNames('1'), "User for this letter does not exist\n");
    }

    @Test
    public void smallPayments() {
        Assert.assertEquals(financeReport.smallPayments(223), "Neyman Ivan Ivanvich date: 11.5.2010 sum: 2 rubles 0 kopecks\n" +
                "Leibniz Ivan Ivanvich date: 3.3.1922 sum: 2 rubles 23 kopecks\n" +
                "Newton Ivan Ivanvich date: 5.4.2012 sum: 0 rubles 23 kopecks\n" +
                "Gauss Ivan Ivanvich date: 7.2.2002 sum: 1 rubles 33 kopecks\n");
    }
}
