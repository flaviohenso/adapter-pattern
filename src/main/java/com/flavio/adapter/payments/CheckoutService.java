package com.flavio.adapter.payments;

/**
 * Código cliente que depende exclusivamente do contrato {@link PaymentProcessor}
 * e permanece desacoplado de implementações específicas.
 */
public class CheckoutService {

    private final PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double total) {
        System.out.println("Iniciando checkout...");
        paymentProcessor.processPayment(total);
        System.out.println("Checkout concluído.");
    }
} 
