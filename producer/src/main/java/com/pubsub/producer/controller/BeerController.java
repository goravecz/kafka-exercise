package com.pubsub.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pubsub.producer.model.Beer;
import com.pubsub.producer.service.BeerService;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerController {

  private static final Logger LOGGER = LoggerFactory.getLogger(BeerController.class);

  private final BeerService beerService;

  public BeerController(final BeerService beerService) {
    this.beerService = beerService;
  }

  @PostMapping(
      value = "/beer",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> addBeer(@Valid @RequestBody final Beer beer)
      throws JsonProcessingException {
    LOGGER.info("Request received={}", beer);
    final var message = beerService.addBeerOrder(beer);
    LOGGER.info("Response sent={}", message);

    return ResponseEntity.accepted().body(message);
  }
}
