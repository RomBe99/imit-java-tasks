package ru.omsu.imit.javatasks.payments;

import java.util.Arrays;

public class FinanceReport {
    private Payment[] payments;

    public FinanceReport(final Payment ... payments) {
        if (payments == null) {
            throw new NullPointerException("Payments array is null");
        }

        this.payments = new Payment[payments.length];

        for (int i = 0; i < payments.length; i++) {
            this.payments[i] = new Payment(payments[i]);
        }
    }

    public FinanceReport(FinanceReport objectForCopy) {
        this(objectForCopy.payments);
    }

    public String outputLastNames(final char firstLetter) {

        StringBuilder sb = new StringBuilder();
        for (Payment p : payments) {
            if (p.getFullName().toLowerCase().charAt(0) == Character.toLowerCase(firstLetter)) {
                sb.append(p.toString());
            }
        }

        if (sb.length() == 0) {
            return "User for this letter does not exist\n";
        }

        return sb.toString();
    }

    public String smallPayments(final int paymentSum) {
        StringBuilder sb = new StringBuilder();

        for (Payment p : payments) {
            if (p.getAmountOfPayment() <= paymentSum) {
                sb.append(p.toString());
            }
        }

        return sb.toString();
    }

    public void setPayment(final Payment payment, final int index) {
        if (payment == null) {
            throw new NullPointerException("Payment is null");
        }

        if (index < 0 || index > payments.length) {
            throw new IllegalArgumentException("Incorrect index");
        }

        payments[index] = new Payment(payment);
    }

    public Payment[] getPayments() {
        return payments;
    }

    public Payment getPayment(final int index) {
        if (index < 0 || index > payments.length) {
            throw new IllegalArgumentException("Incorrect index");
        }

        return payments[index];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceReport that = (FinanceReport) o;
        return Arrays.equals(payments, that.payments);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(payments);
    }
}
