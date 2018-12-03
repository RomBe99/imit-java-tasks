package ru.omsu.imit.javatasks.payments;

public class FinanceReport {
    private Payment[] payments;

    public FinanceReport(Payment ... payments) {
        if (payments == null) {
            throw new NullPointerException("Payments array is null");
        }

        this.payments = payments;
    }

    public void outputLastNames(char firstLetter) {
        for (Payment p : payments) {
            if (p.getFullName().charAt(0) == firstLetter) {
                System.out.println(p.toString());
            }
        }
    }

    public void smallPayments(int paymentSum) {
        for (Payment p : payments) {
            if (p.getAmountOfPayment() < paymentSum) {
                System.out.println(p.toString());
            }
        }
    }

    public void setPayment(Payment payment, int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Incorrect index");
        }

        if (payment == null) {
            throw new NullPointerException("ru.omsu.imit.javatasks.payments.Payment is null");
        }

        payments[index] = payment;
    }

    public Payment getPayment(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Incorrect index");
        }

        return payments[index];
    }
}
