package com.flavio.adapter.payments;

/**
 * Target interface (Novo Sistema)
 *
 * Define o contrato que o código cliente espera.
 */
public interface PaymentProcessor {

    /**
     * Processa um pagamento no valor indicado.
     *
     * @param amount valor a ser processado
     */
    void processPayment(double amount);
} 
