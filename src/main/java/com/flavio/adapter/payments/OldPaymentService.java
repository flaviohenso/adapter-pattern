package com.flavio.adapter.payments;

/**
 * Adaptee (Sistema legado)
 *
 * Biblioteca de terceiros ou sistema que não pode ser modificado
 * e cuja interface é incompatível com {@link PaymentProcessor}.
 */
public class OldPaymentService {

    /**
     * Método existente no sistema legado.
     *
     * @param value valor a ser pago
     */
    public void makePayment(float value) {
        System.out.printf("Pagamento de R$ %.2f realizado no sistema legado.%n", value);
    }
} 
