package com.pubsub.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pubsub.consumer.model.BeerOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
  private static final String ORDER_TOPIC = "beer-topic";

  private final ObjectMapper objectMapper;
  private final BeerOrderService beerService;

  public Consumer(final BeerOrderService beerService, final ObjectMapper objectMapper) {
    this.beerService = beerService;
    this.objectMapper = objectMapper;
  }

  @KafkaListener(topics = ORDER_TOPIC)
  public void consumeBeerOrder(final String message) throws JsonProcessingException {
    LOGGER.info("Beer order consumed={}", message);

    // final var beerOrder = objectMapper.readValue(message, BeerOrder.class);
    // beerService.process(beerOrder);
  }
}
