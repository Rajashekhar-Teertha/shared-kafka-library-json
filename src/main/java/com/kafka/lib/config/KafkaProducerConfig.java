package com.kafka.lib.config;

import com.kafka.lib.entity.Booking;
import com.maersk.shared.kafka.configuration.KafkaSenderBaseConfiguration;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonSerializer;

/**
 * Kafka producer class to extend the properties from library class
 */
@Configuration
public class KafkaProducerConfig extends KafkaSenderBaseConfiguration<String, Booking> {
  @Override
  protected Map<String, Object> kafkaProducerProperties() {
    Map<String, Object> properties = super.kafkaProducerProperties();
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    return properties;
  }
}