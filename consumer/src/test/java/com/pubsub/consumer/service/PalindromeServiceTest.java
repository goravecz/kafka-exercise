package com.pubsub.consumer.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeServiceTest {

  PalindromeService palindromeService;

  @BeforeEach
  void setUp() {
    palindromeService = new PalindromeService();
  }

  @Test
  void shouldReturnWordLengthWhenSmallerThanTwo() {
    assertEquals(2, palindromeService.calculateLongestPalindrome("aa+b"));
  }

  @Test
  void shouldReturnLongestPalindromeWhenEven() {
    assertEquals(4, palindromeService.calculateLongestPalindrome("abba"));
  }

  @Test
  void shouldReturnLongestPalindromeWhenOdd() {
    assertEquals(5, palindromeService.calculateLongestPalindrome("abcba"));
  }

  @Test
  void shouldReturnZeroWhenNoAlphaNumericCharactersFound() {
    assertEquals(0, palindromeService.calculateLongestPalindrome("!!!!"));
  }
}