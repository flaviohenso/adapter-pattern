package com.flavio.adapter;

import com.flavio.adapter.payments.*;

/**
 * Demonstração do padrão Adapter.
 */
public class Main {

    public static void main(String[] args) {
        double valor = 199.99;

        // Usando o Object Adapter
        PaymentProcessor objectAdapter =
                new PaymentServiceObjectAdapter(new OldPaymentService());
        CheckoutService checkout1 = new CheckoutService(objectAdapter);
        checkout1.checkout(valor);

        System.out.println("-----------------------");

        // Usando o Class Adapter
        PaymentProcessor classAdapter = new PaymentServiceClassAdapter();
        CheckoutService checkout2 = new CheckoutService(classAdapter);
        checkout2.checkout(valor);
    }
} 
