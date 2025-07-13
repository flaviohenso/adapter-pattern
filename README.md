# Padrão de Projeto – Adapter (Java 21)

## Objetivo
O **Adapter** permite que duas interfaces incompatíveis colaborem.
Ele age como um **tradutor**, convertendo chamadas da interface esperada pelo cliente (_Target_) para a interface de um componente legado ou de terceiros (_Adaptee_).

## Estrutura

```
Client ──> Target (PaymentProcessor) <── Adapter ──> Adaptee (OldPaymentService)
                ▲                               ▲
                │                               │
          CheckoutService                 Serviço legado
```

* **Target** – `PaymentProcessor`: contrato novo, usado pelo código cliente.
* **Adaptee** – `OldPaymentService`: serviço legado que não pode ser alterado.
* **Adapter** – `PaymentServiceObjectAdapter` ou `PaymentServiceClassAdapter`: faz a conversão.
  * *Object Adapter* usa **composição**.
  * *Class Adapter* usa **herança** (possível apenas em linguagens com herança simples ou múltipla).
* **Client** – `CheckoutService`/`Main`: depende apenas de `PaymentProcessor`.

## Execução

```bash
mvn clean package
java -jar target/adapter-pattern-1.0.0.jar
```

Saída esperada:

```
Iniciando checkout...
Pagamento de R$ 199,99 realizado no sistema legado.
Checkout concluído.
-----------------------
Iniciando checkout...
Pagamento de R$ 199,99 realizado no sistema legado.
Checkout concluído.
```

## Detalhes de implementação

1. **Interface Target (`PaymentProcessor`)**
   ```java
   public interface PaymentProcessor {
       void processPayment(double amount);
   }
   ```
2. **Adaptee (`OldPaymentService`)**
   Possui método `makePayment(float)`, incompatível com o contrato acima.
3. **Adapter (Object)**
   ```java
   public class PaymentServiceObjectAdapter implements PaymentProcessor {
       private final OldPaymentService oldService;
       public void processPayment(double amount) {
           oldService.makePayment((float) amount);
       }
   }
   ```
4. **Adapter (Class)**
   ```java
   public class PaymentServiceClassAdapter
               extends OldPaymentService
               implements PaymentProcessor {
       public void processPayment(double amount) {
           makePayment((float) amount);
       }
   }
   ```
5. **Cliente (`CheckoutService`)**
   Recebe qualquer implementação de `PaymentProcessor`, favorecendo **Injeção de Dependência**.

## Quando usar?

* Reaproveitar código legado sem modificá-lo.
* Integrar bibliotecas de terceiros com API diferente da esperada.
* Migrar gradualmente para novas APIs mantendo compatibilidade.

## Vantagens

* Separa a **lógica de adaptação** do código cliente.
* Favorece **Baixo acoplamento** e **Open/Closed**.
* Pode ser introduzido sem alterar o sistema legado.

## Desvantagens

* Aumento da complexidade; muitos _adapters_ podem poluir a base.
* Pode haver overhead de delegação/conversão.

## Java 21

O exemplo utiliza recursos do Java 21 (alvo de compilação) e segue boas práticas modernas:
* Formatação de _strings_ com `String#formatted` (não usado no exemplo simplificado).
* Uso de _records_ seria possível para DTOs, mas aqui **não** acrescentaria valor extra.

---

> Desenvolvido por `flaviohenso`
> Diretório do projeto: `/home/flavio/Projetos/adapter-pattern` 
