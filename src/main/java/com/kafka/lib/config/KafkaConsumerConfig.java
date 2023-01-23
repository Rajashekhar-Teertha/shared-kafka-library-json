package com.kafka.lib.config;

import com.kafka.lib.entity.Booking;
import com.maersk.shared.kafka.configuration.KafkaReceiverBaseConfiguration;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;

/**
 * Kafka consumer class to extend the properties from library class
 */
@Configuration
public class KafkaConsumerConfig extends KafkaReceiverBaseConfiguration<String, Booking> {
  @Override
  protected Map<String, Object> kafkaConsumerProperties() {
    Map<String, Object> properties = super.kafkaConsumerProperties();
    properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
    properties.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, StringDeserializer.class);
    return properties;
  }
}
