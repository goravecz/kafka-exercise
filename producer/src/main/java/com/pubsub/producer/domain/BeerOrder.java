package com.pubsub.producer.domain;

import java.util.Objects;

public final class BeerOrder {

  private final String content;
  private final String timestamp;

  public BeerOrder(final String content, final String timestamp) {
    this.content = content;
    this.timestamp = timestamp;
  }

  public String getContent() {
    return content;
  }

  public String getTimestamp() {
    return timestamp;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final BeerOrder beerOrder = (BeerOrder) o;

    if (!Objects.equals(content, beerOrder.content)) {
      return false;
    }
    return Objects.equals(timestamp, beerOrder.timestamp);
  }

  @Override
  public int hashCode() {
    int result = content != null ? content.hashCode() : 0;
    result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Beer{" + "content='" + content + '\'' + ", timeStamp='" + timestamp + '\'' + '}';
  }
}
