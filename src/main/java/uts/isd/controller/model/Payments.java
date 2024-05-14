package uts.isd.controller.model;

import uts.isd.model.Payment;
import uts.isd.model.PaymentMethod;

import java.util.List;

public class Payments {

    private final List<Payment> payments;

    private final PaymentMethod paymentMethod;

    public Payments(List<Payment> payments, PaymentMethod paymentMethod) {
        this.payments = payments;
        this.paymentMethod = paymentMethod;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
