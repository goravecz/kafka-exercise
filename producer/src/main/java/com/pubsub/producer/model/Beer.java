package com.pubsub.producer.model;

import com.pubsub.producer.validator.Timestamp;
import java.util.Objects;
import javax.validation.constraints.NotNull;

public final class Beer {

  @NotNull(message = "The content cannot be null.")
  private final String content;

  @NotNull(message = "The timestamp cannot be null.")
  @Timestamp(message = "Invalid timestamp."
          + "Follow the uuuu-MM-dd HH:mm:ssZ format! e.g.: 2018-10-09 00:12:12+0100")
  private final String timestamp;

  public Beer(final String content, final String timestamp) {
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

    final Beer beer = (Beer) o;

    if (!Objects.equals(content, beer.content)) {
      return false;
    }
    return Objects.equals(timestamp, beer.timestamp);
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
