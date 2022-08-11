package com.pubsub.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pubsub.producer.converter.BeerConverter;
import com.pubsub.producer.model.Beer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeerService {

  private static final Logger LOGGER = LoggerFactory.getLogger(BeerService.class);

  private final BeerConverter beerConverter;
  private final Producer producer;

  @Autowired
  public BeerService(final BeerConverter beerConverter, final Producer producer) {
    this.beerConverter = beerConverter;
    this.producer = producer;
  }

  public String addBeerOrder(Beer beer) throws JsonProcessingException {
    LOGGER.info("Beer received={}", beer);
    var beerOrder = beerConverter.convertToBeerOrder(beer);

    return producer.placeOrder(beerOrder);
  }
}
