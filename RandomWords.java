package guessTheWorldGame;

import java.util.*;

public class RandomWords {
	
	//random word list
	private String randomWords [] = {"airplane", "ears","bat","ball", "cold","blink", 
			"hairbrush", "toothbrush", "scissors", "boat","balloon", "balance","shoelaces", "monster","hiccup",
			"fishing", "measure", "overwhelm"};
	
	//create Random Class object to generate Random integers
	private Random rdm = new Random();
	
	//store Random generated Word form the given list
	private String selectWord;
	
	//userGuesses Input letters are stored in this char array and other spaces are NULL until all the letters are guessed.
	private char [] letters;
	
	//declare the Constructor
	public RandomWords() {
		
		//generate random word when the RandomWords Object created
		selectWord = randomWords[rdm.nextInt(0, randomWords.length)];
		
		//set the letters char array length to random generated word length.
		letters = new char[selectWord.length()];
	}
	
	//When object is printed, then this method will be called
	public String toString() {
		
		//this class helps to create mutable(changeable) string and its fast than Concatenating a String
		StringBuilder word = new StringBuilder();
		
		//check whether letters array has Null values, if yes, then print '-' and if not then print that letter
		for( char letter : letters) {
			
			word.append(letter == '\u0000' ? '-' : letter);
		}
		//return whole word object as a string, we cannot return word because its a object.
		return word.toString();
	}
	
	//checking the user guessed letter is correct or not, if correct then that letter assigned to the given index in letters array
	public boolean guess(char letter) {
		
		//this uses to control game rounds, if this false(guessed letter is wrong) game round will be decreased. 
		boolean guessRight = false;
		
		for(int i = 0; i < selectWord.length(); i++) {
			
			if( letter == selectWord.charAt(i)){
				
				letters[i] = letter;
				guessRight = true;
			}
		}
		return guessRight;
	}
	
	//this function checks whether user guessed the whole word or not, if guessed the game is Over and user will win!
	public boolean checkWord() {
		
		//iterate through the letters array and checks whether it has NULL values, if not the world is complete and user won
		for(char letter : letters) {
			
			if( letter == '\u0000') {
				
				//this is use to control game play do while loop
				return false;
			}
		}
		
		return true;
		
	}
	
	//return select word
	public String getRanomWord() {
		return selectWord;
	}
}
