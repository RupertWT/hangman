package com.rupert.hangman;

import java.util.ArrayList;

public class HangmanLogic {
    
	public boolean won = false;
	
	public ArrayList<Integer> main( String word , String letter ) {

		ArrayList<Integer> resultList = new ArrayList<Integer>();
		
		for (int i = 0; i < word.length(); i++) {
			
			if (word.substring(i,i+1).equalsIgnoreCase(letter)) {
				resultList.add(i);
			}
		}
		return resultList;
    }
    
}
