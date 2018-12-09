package ru.omsu.imit.javatasks.payments;

public class FinanceReport {
    private Payment[] payments;

    public FinanceReport(final Payment ... payments) throws NullPointerException {
        if (payments == null) {
            throw new NullPointerException("Payments array is null");
        }

        for (Payment p : payments) {
            if (p == null) {
                throw new NullPointerException("Element array is null");
            }
        }

        this.payments = payments;
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

    public void setPayment(final Payment payment, final int index) throws IllegalArgumentException, NullPointerException {
        if (index < 0 || index > payments.length) {
            throw new IllegalArgumentException("Incorrect index");
        }

        if (payment == null) {
            throw new NullPointerException("Payment is null");
        }

        payments[index] = payment;
    }

    public Payment[] getPayments() {
        return payments;
    }

    public Payment getPayment(final int index) throws IllegalArgumentException {
        if (index < 0 || index > payments.length) {
            throw new IllegalArgumentException("Incorrect index");
        }

        return payments[index];
    }
}
