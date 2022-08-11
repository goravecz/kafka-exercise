package com.pubsub.consumer.service;

import com.pubsub.consumer.domain.EnrichedBeerOrder;
import com.pubsub.consumer.model.BeerOrder;
import com.pubsub.consumer.repository.BeerOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BeerOrderService {

  private static final Logger LOGGER = LoggerFactory.getLogger(BeerOrderService.class);

  private final PalindromeService palindromeService;
  private final BeerOrderRepository beerOrderRepository;

  public BeerOrderService(
      final PalindromeService palindromeService, final BeerOrderRepository beerOrderRepository) {
    this.palindromeService = palindromeService;
    this.beerOrderRepository = beerOrderRepository;
  }

  public void process(final BeerOrder beerOrder) {
    LOGGER.info("BeerOrder received={}", beerOrder);
    final var longestPalindromeSize =
        palindromeService.calculateLongestPalindrome(beerOrder.getContent());

    final var enrichedBeerOrder = new EnrichedBeerOrder(
            beerOrder.getContent(), beerOrder.getTimestamp(), longestPalindromeSize);
    
    LOGGER.info("EnrichedBeerOrder={}", enrichedBeerOrder);
    // beerOrderRepository.persist(
    //    new EnrichedBeerOrder(beerOrder.getContent(), beerOrder.getTimestamp(),
    // longestPalindromeSize));
  }
}
