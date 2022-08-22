package guessTheWorldGame;

import java.util.Scanner;

public class GuessTheWord {
	
	//do while loop condition, this depends on the userInputs
	private boolean play = true;

	//create a Random Words class object to use those methods and attributes
	private RandomWords rdmword = new RandomWords();

	//create a scanner object to get Inputs From the User
	private Scanner scn = new Scanner(System.in);
	
	//Create Game rounds variable, if user will enter a wrong letter, this will decreased one by one
	private int rounds = 10;

	//We store user input in this variable
	private String guess;
	
	//create gameLogo Object to print GameLogos
	logo gamelogo = new logo();
	
	//this is the start Function, This controls the iteration of the Game
	public void start() {

		do {
			showTheWord(); //this shows the random word with - and guessed letters, also it shows the number of rounds you have left
			getInput(); // get the user inputs
			checkInput(); // check user inputs and validate and decreased rounds or stop while do loop if the word is completed

		} while (play); // do while loop condition
	}
	
	//Printing  random word and number of chances you have left
	void showTheWord() {
		System.out.println("You have " + rounds + " left to win..");
		System.out.println(rdmword);
	}
	
	//getting user Inputs
	void getInput() {

		System.out.println("Enter a letter to guess the word...:");
		guess = scn.nextLine();

	}
	
	//validate user inputs
	void checkInput() {
		
		//sends the user inputs to the guess class in the RandomWords class and if the letter is correct 
		//then returns the true
		//if its wrong then return false
		boolean isGuessRight = rdmword.guess(guess.charAt(0));
		
		//if user guessed correct letter
		if(isGuessRight) {
			//then checks the whole world was guessed by user or not
			if (rdmword.checkWord()) {
				
				//if yes, this messages will print on the console 
				System.out.println(gamelogo.getGameWonLogo());
				
				//this also, to print rdmword object, toString functions(in the RandomWord class) will help 
				System.out.println("The Word is: " + rdmword);
				
				//while loop condition will be false and loop will stop
				play = false;
			}

		}
		//if the user guessed letter is wrong
		else {
			//decreased the number of rounds the player left
			rounds--;
			
			//if the play rounds equals to Zero that means the user is lost the game!
			if( rounds == 0) {
				//then this will print on the console
				System.out.println(gamelogo.getGameOverLogo());
				
				//the word printed
				System.out.println("The Word is: " + rdmword.getRanomWord());
				//and do while loop will be terminated
				play = false;
			}
		}

	}
	//even the while do loop stops, the scanner will expect a input from the user. So to prevent that thing after terminating the while loop
	//we close the scanner object too
	public void end() {
		scn.close();
	}
	
	//print the game Logo on the terminal
	public void startInfo() {
		//this will print the game logo
		System.out.println(gamelogo.getGameInfoLogo());
		
	}
}
