package com.alura.pix.config;

import com.alura.pix.dto.PixDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConsumerKafkaConfig {

    @Value(value = "${spring.kafka.bootstrap-servers:localhost:9092}")
    private String bootstrapAddress;

    @Bean
    public ProducerFactory<String, PixDTO> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        configProps.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        configProps.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, PixDTO> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ConsumerFactory<String, PixDTO> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);
        props.put(
                JsonDeserializer.TRUSTED_PACKAGES,
                "*");
        // valor padrão 500, essa config pega uma grande quantidade de mensagens para processar e assim evitar várias conexões
        props.put(
                ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
        // A partir de quando as mensagens serão lidas: padrão é latest = pega as mensagens novas, ignorando mensagens recebidas antes no tópico, após a aplicação subir
        // earliest pega as mensagens mais antigas do tópico
        props.put(
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        // padrão true = cria o tópico no kafka caso não exista
        props.put(
                ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG, false);
        // se true = kafka processa a mensagem e então faz o commit
        props.put(
                ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG, false);

        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PixDTO>
        kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, PixDTO> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
