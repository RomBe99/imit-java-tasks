public class FinanceReport {
    private Payment[] payments;

    public FinanceReport(Payment ... payments) {
        if (payments == null) {
            throw new NullPointerException("Payments array is null");
        }

        this.payments = payments;
    }

    public void setPayment(Payment payment, int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Incorrect index");
        }

        if (payment == null) {
            throw new NullPointerException("Payment is null");
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
