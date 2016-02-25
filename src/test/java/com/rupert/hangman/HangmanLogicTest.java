package com.rupert.hangman;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HangmanLogicTest {
  
	HangmanLogic logic = new HangmanLogic();
	
	@Test
    public void lowercaseLetterBWrongInAwesome()
    {
		List<Integer> expected = new ArrayList<Integer>();
		assertEquals(expected,logic.main("Awesome","b"));
    }
	
	@Test
    public void lowercaseLetterACorrectInAwesome()
    {
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		assertEquals(expected,logic.main("Awesome","a"));
    }
	
	@Test
    public void capitalLetterECorrectInAwesome()
    {
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(2);
		expected.add(6);
		assertEquals(expected, logic.main("Awesome","E")); 
    }
	
}
