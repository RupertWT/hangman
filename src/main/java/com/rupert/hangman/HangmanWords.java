package com.rupert.hangman;

public class HangmanWords {
	
	public String [] words =   //choose secret word from these
		{"this word doesn't get picked EVER", "word", "yesterday", "java", "truck", "opportunity",
			"fish", "token", "transportation", "bottom", "apple", "cake",
			"remote", "pocket", "terminology", "arm", "cranberry", "tool",
			"caterpillar", "spoon", "watermelon", "laptop", "toe", "toad",
			"fundamental", "capitol", "garbage", "anticipate", "apple", "gazibo"};
	
	public String main( ) {
   
		int random = (int)(Math.random() * 30 + 1 );
		String word = words[random];
		System.out.println(word);
		return word;
		
	}
    
}
