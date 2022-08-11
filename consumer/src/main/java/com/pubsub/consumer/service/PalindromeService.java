package com.pubsub.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PalindromeService {

  private static final Logger LOGGER = LoggerFactory.getLogger(PalindromeService.class);

  private int resultStart;
  private int resultLength;

  public int calculateLongestPalindrome(final String content) {
    LOGGER.info("Received content={}", content);

    final var word = findLongestAlphaNumericSubString(content);
    var wordLength = word.length();
    if (wordLength < 2) {
      return wordLength;
    }

    for (int start = 0; start < wordLength - 1; start++) {
      extendRange(word, start, start);
      extendRange(word, start, start + 1);
    }
    int longestPalindrome = word.substring(resultStart, resultStart + resultLength).length();
    LOGGER.info("Longest palindrome={}", longestPalindrome);

    return longestPalindrome;
  }

  private void extendRange(String word, int left, int right) {
    while (left >= 0 && right < word.length() && word.charAt(left) == word.charAt(right)) {
      left--;
      right++;
    }
    if (resultLength < right - left - 1) {
      resultStart = left + 1;
      resultLength = right - left - 1;
    }
  }

  private String findLongestAlphaNumericSubString(final String content) {
    String[] strings = content.split("[^a-zA-Z0-9]");
    if (strings.length == 0) {
      return "";
    }
    int index = 0;
    int longestSoFar = strings[0].length();
    for (int i = 1; i < strings.length; i++) {
      if (strings[i].length() > longestSoFar) {
        index = i;
        longestSoFar = strings[i].length();
      }
    }

    return strings[index];
  }
}
