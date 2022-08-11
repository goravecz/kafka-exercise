package com.pubsub.producer.converter;

import com.pubsub.producer.controller.BeerController;
import com.pubsub.producer.domain.BeerOrder;
import com.pubsub.producer.model.Beer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BeerConverter {

  private static final Logger LOGGER = LoggerFactory.getLogger(BeerController.class);

  public BeerOrder convertToBeerOrder(final Beer beer) {
    LOGGER.info("Beer order to convert={}", beer);

    return new BeerOrder(beer.getContent(), beer.getTimestamp());
  }
}
