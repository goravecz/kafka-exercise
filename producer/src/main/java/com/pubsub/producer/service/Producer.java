package com.pubsub.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pubsub.producer.domain.BeerOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

  private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

  @Value("${spring.kafka.topic}")
  private String orderTopic;

  private final KafkaTemplate<String, String> kafkaTemplate;
  private final ObjectMapper objectMapper;

  @Autowired
  public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
    this.kafkaTemplate = kafkaTemplate;
    this.objectMapper = objectMapper;
  }

  public String placeOrder(BeerOrder beerOrder) throws JsonProcessingException {
    String beerOrderMessage = objectMapper.writeValueAsString(beerOrder);
    kafkaTemplate.send(orderTopic, beerOrderMessage);
    LOGGER.info("Food order produced={}", beerOrderMessage);

    return "Beer order placed in the queue!";
  }
}
