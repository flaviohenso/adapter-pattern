package com.flavio.adapter.payments;

/**
 * Class Adapter
 *
 * Adapta {@link OldPaymentService} para {@link PaymentProcessor}
 * usando herança.
 */
public class PaymentServiceClassAdapter extends OldPaymentService implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        // reutiliza o método herdado
        makePayment((float) amount);
    }
} 
