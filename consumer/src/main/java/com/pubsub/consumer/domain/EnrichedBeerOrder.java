package com.pubsub.consumer.domain;

public class EnrichedBeerOrder {

  private final String content;
  private final String timestamp;
  private final int longestPalindromeSize;

  public EnrichedBeerOrder(
      final String content, final String timestamp, final int longestPalindromeSize) {
    this.content = content;
    this.timestamp = timestamp;
    this.longestPalindromeSize = longestPalindromeSize;
  }

  public String getContent() {
    return content;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public int getLongestPalindromeSize() {
    return longestPalindromeSize;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final EnrichedBeerOrder that = (EnrichedBeerOrder) o;

    if (longestPalindromeSize != that.longestPalindromeSize) {
      return false;
    }
    if (!content.equals(that.content)) {
      return false;
    }
    return timestamp.equals(that.timestamp);
  }

  @Override
  public int hashCode() {
    int result = content.hashCode();
    result = 31 * result + timestamp.hashCode();
    result = 31 * result + longestPalindromeSize;
    return result;
  }

  @Override
  public String toString() {
    return "EnrichedBeerOrder{"
        + "content='"
        + content
        + '\''
        + ", timestamp='"
        + timestamp
        + '\''
        + ", longestPalindromeSize="
        + longestPalindromeSize
        + '}';
  }
}
