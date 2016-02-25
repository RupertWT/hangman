package com.rupert.hangman;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HangmanWordsTest {
  
	HangmanWords words = new HangmanWords();
	
	@Test
    public void lowercaseLetterBWrongInAwesome()
    {
		assertEquals("word",words.main());
    }
	
}
