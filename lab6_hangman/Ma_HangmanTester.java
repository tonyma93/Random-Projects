package lab6_hangman;
import common.MyScanner;

public class Ma_HangmanTester {

	/* This program implements the "hangman" game using two additional classes: 
	 * "Hangman" and "RandomAnimal". The player must guess all of the letters of 
	 * a secret (or hidden) word before the game completes drawing all the body 
	 * parts of a hangman (head, then neck, then arms, then torso, then legs). 
	 * The hangman gets an additional body part only when there is an incorrect 
	 * guess. 
	 * 
	 * Programmer: Sally Kyvvernitis, Date 10-2-16  
	 * 
	 * Modified by [[Tony Ma 10/13/16]]
	 * 
	 */

	public static void main(String[] args) {

		// declarations
		MyScanner keyboard = new MyScanner(); // this object used for getting input
		Hangman hangman = new Hangman();  // declare and instantiate a Hangman game object

		String guessLetter = "";  // this is the letter the player will guess
		String guessMessage = ""; // this is the response (from hangman object) 
		boolean go = true;        // game loop continues only as long as this is true.

		//hangman.setHiddenWord("Temple");
		// For the real game you would not show the hidden word, but leave it in so 
		// you can test and we can grade. 
		

		// Right now, this prints a full hangman body 5 times. Once you have fixed the 
		// printHangman() method, it should print just the head the first time, then the 
		// head and neck the second time, ..., and the full body only the 5th time. 
		// Comment this line out before you submit hour homework. 
		//hangman.temporaryTester();

		// Game Loop
		while (go) {

			// get user's guess letter and hangman's response to that guess
			System.out.println();
			System.out.print("Guess a letter: ");
			guessLetter = keyboard.nextString();
			guessMessage = hangman.guess(guessLetter);

			// print out hangman's response, some game stats, and the partial hangman image
			System.out.println("      "+guessMessage+"  Reveal Word is " + hangman.getRevealWord()+
					".  Wrong Guesses So Far: "+hangman.getWrongLettersGuessed());
			hangman.printHangman();

			// check for win or loss
			if (hangman.hasWon()) {
				System.out.println(" !*!*!    You just won the game!    !*!*!");
				go = false;
			} else if (hangman.hasLost()){
				System.out.println(" !*!*!    You just lost the game!    !*!*!");
				go = false;
				System.out.println("Hidden word is "+hangman.getHiddenWord());
			} 
		} // while loop
		System.out.println();
		System.out.println("Want to play again?");
	} // end main

} // end class