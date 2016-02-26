package com.rupert.hangman;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.Test;

public class HangmanLogicTest {
  
	HangmanLogic logic = new HangmanLogic();
	
	@Test
    public void lowercaseLetterBWrongInAwesome()
    {
		ArrayList<Integer> expected = new ArrayList<Integer>();
		assertEquals(expected,logic.main("Awesome","b"));
    }
	
	@Test
    public void lowercaseLetterACorrectInAwesome()
    {
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		assertEquals(expected,logic.main("Awesome","a"));
    }
	
	@Test
    public void capitalLetterECorrectInAwesome()
    {
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(2);
		expected.add(6);
		assertEquals(expected, logic.main("Awesome","E")); 
    }
	
	@Test
    public void capitalLetterEReturns2SizeArrayList()
    {
		assertEquals(2, logic.main("Awesome","E").size()); 
    }
	
}
