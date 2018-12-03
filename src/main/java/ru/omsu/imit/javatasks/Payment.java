package ru.omsu.imit.javatasks;

import java.util.Objects;

public class Payment {
    private String fullName;
    private byte day;
    private byte month;
    private int year;
    private int amountOfPayment;

    public Payment(final String fullName, final byte day, final byte month, final int year, final int amountOfPayment) throws Exception {
        setFullName(fullName);
        setDay(day);
        setMonth(month);
        setYear(year);
        setAmountOfPayment(amountOfPayment);
    }

    public void setFullName(final String fullName) throws NullPointerException {
        if (fullName == null) {
            throw new NullPointerException("Full name is null");
        }

        this.fullName = fullName;
    }

    public void setDay(final byte day) throws Exception {
        if (day > 32 || day < 1) {
            throw new Exception("Incorrect day number");
        }

        this.day = day;
    }

    public void setMonth(final byte month) throws Exception {
        if (month > 32 || month < 1) {
            throw new Exception("Incorrect month number");
        }

        this.month = month;
    }

    public void setYear(final int year) throws Exception {
        if (year > 2019 || year < 1900) {
            throw new Exception("Incorrect year");
        }

        this.year = year;
    }

    public void setAmountOfPayment(final int amountOfPayment) throws Exception {
        if (amountOfPayment <= 0) {
            throw new Exception("Incorrect amount of payment");
        }

        this.amountOfPayment = amountOfPayment;
    }

    public String getFullName() {
        return fullName;
    }

    public byte getDay() {
        return day;
    }

    public byte getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getAmountOfPayment() {
        return amountOfPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return day == payment.day &&
                month == payment.month &&
                year == payment.year &&
                amountOfPayment == payment.amountOfPayment &&
                Objects.equals(fullName, payment.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, day, month, year, amountOfPayment);
    }

    @Override
    public String toString() {
        return  fullName +
                " date: " + day +
                '.' + month +
                '.' + year +
                " sum: " + amountOfPayment / 100 + "rubles " + amountOfPayment % 100 + "kopecks";
    }
}
