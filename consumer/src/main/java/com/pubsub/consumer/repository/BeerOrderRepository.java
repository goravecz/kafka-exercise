package com.pubsub.consumer.repository;

import com.pubsub.consumer.domain.EnrichedBeerOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BeerOrderRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(BeerOrderRepository.class);

  public void persist(final EnrichedBeerOrder enrichedBeerOrder) {

  }
}
