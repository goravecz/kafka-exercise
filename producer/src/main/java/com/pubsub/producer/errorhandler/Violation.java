package com.pubsub.producer.errorhandler;

import java.util.Objects;

public class Violation {

  private final String fieldName;
  private final String message;

  public Violation(final String fieldName, final String message) {
    this.fieldName = fieldName;
    this.message = message;
  }

  public String getFieldName() {
    return fieldName;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final Violation violation = (Violation) o;

    if (!Objects.equals(fieldName, violation.fieldName)) {
      return false;
    }
    return Objects.equals(message, violation.message);
  }

  @Override
  public int hashCode() {
    int result = fieldName != null ? fieldName.hashCode() : 0;
    result = 31 * result + (message != null ? message.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Violation{" + "fieldName='" + fieldName + '\'' + ", message='" + message + '\'' + '}';
  }
}
