package com.flavio.adapter.payments;

/**
 * Object Adapter
 *
 * Adapta {@link OldPaymentService} para o contrato {@link PaymentProcessor}
 * usando composição (objeto interno).
 */
public class PaymentServiceObjectAdapter implements PaymentProcessor {

    private final OldPaymentService oldService;

    public PaymentServiceObjectAdapter(OldPaymentService oldService) {
        this.oldService = oldService;
    }

    @Override
    public void processPayment(double amount) {
        // Realiza a conversão necessária e delega
        oldService.makePayment((float) amount);
    }
} 
