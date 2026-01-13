package br.com.alura.ecommerce;

import org.apache.kafka.clients.producer.Callback;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // fecha o dispatcher caso ocorra alguma excessão
        try (var dispatcher = new KafkaDispatcher()) {

            for (var i = 0; i < 10; i++) {
                // Chave que decide em qual partição irá cair a mensagem
                var key = UUID.randomUUID().toString(); // aleatoriza a chave para não cair sempre na mesma partição
                var value = key + "67523,1234";
                // envio
                dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);

                var email = "Thank you for your order! We are processing your order!";
                dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);
            }
        }
    }

    private static Callback getCallback() {
        return (data, ex) -> {
            if (ex != null) {
                ex.printStackTrace();
                return;
            }
            System.out.println("sucesso enviando " + data.topic() + ":::partition " + data.partition() + "/ offset " + data.offset() + "/ timestamp " + data.timestamp());
        };
    }
}
