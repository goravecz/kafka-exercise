package com.pubsub.producer.controller;

import com.pubsub.producer.model.request.Beer;
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

  @PostMapping(
      value = "/beer",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Beer> addBeer(@Valid @RequestBody final Beer beer) {

    LOGGER.info("Beer data received={}", beer);

    return ResponseEntity.accepted().body(beer);
  }
}
