package com.pubsub.producer.validator;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimestampValidator implements ConstraintValidator<Timestamp, String> {

  private static final Logger LOGGER = LoggerFactory.getLogger(TimestampValidator.class);

  @Override
  public boolean isValid(final String timestamp, final ConstraintValidatorContext constraintValidatorContext) {
    final var dateTimeFormatter =
        DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ssZ")
            .withResolverStyle(ResolverStyle.STRICT);

    try {
      ZonedDateTime.parse(timestamp, dateTimeFormatter);
      return true;
    } catch (final DateTimeParseException exception) {
      LOGGER.error("Invalid timestamp.", exception);
      return false;
    }
  }
}
