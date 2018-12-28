package lab6_hangman;

public class Hangman {

	/* This class contains code for the "hangman" game. The constructor gets
	 * a random word (from class "RandomAnimal" --> this.hiddenWord) and sets
	 * this.revealWord so that it has as many stars as hiddenWord has letters. 
	 * 
	 * To play the game, call the guess method repeatedly, passing in the player's 
	 * guessed letter. Method guess returns a response indicating whether the 
	 * player's guess was correct, incorrect, etc.  
	 * 
	 * To show the updated partial hangman figure, call method printHangman(). 
	 * To show the updated revealWord, call method getRevealWord()
	 * To show the list of wrong letters guessed so far, call getWrongLettersGuessed()
	 * 
	 * To find out if the player has won or lost the game, call boolean methods 
	 * hasWon() and hasLost(). 
	 * 
	 * You normally would not need to call getHiddenWord() unless you are testing
	 * (or we are grading). 
	 * 
	 * Programmer: Sally Kyvvernitis, Date 10-2-16  
	 * 
	 * Modified by [[Tony Ma, 10/13/16]]
	 * 
	 */

	/************ Data Members of a Hangman object ***************************/
	final int MAX_WRONG_GUESSES = 5;

	// This should normally be private (to achieve encapsulation/protection of data), 
	// but I made it public for reasons of testing/debugging (see lab hw submission).
	public String hiddenWord = ""; // The name of an animal (randomly selected)

	// Initially, this is a word with as many stars as there are letters in hiddenWord
	// As the game progresses (and the user guesses correct letters of the animal name), 
	// the stars in this word become replaced by the correctly guessed letters.
	private String revealWord = ""; 

	// A list of all the letters that have been guessed, that are not in the hidden word
	private String wrongLettersGuessed = "";

	/*************************************************************************/

	// default constructor (this code is run when a hangman object is instantiated).
	public Hangman () {
		this.revealWord = "";  

		// Set a secret/hidden word and then capitalize the secret word
		this.hiddenWord = RandomAnimal.getRandomAnimal();
		this.hiddenWord = this.hiddenWord.toUpperCase();

		// Set "revealWord" to have has as many stars as there are characters
		// in hiddenWord
		for (int i=0; i < this.hiddenWord.length(); i++) {
			this.revealWord = revealWord+"*"; 
		}
	}

	// This method determines whether or not the user's 
	// "guess" letter is correct and returns a message for 
	// the user. Messages would be like:
	//   1. "Please guess a single letter" (check letter.length())  or
	//   2. "That letter has already been guessed" (could have been right or wrong) or
	//   3. "Incorrect guess" (add the guessed letter to the list of wrongly guessed letters)
	//   4. "Correct" (reveal all of the letters within revealWord that match the guess)
	public String guess (String letter) {

		letter = letter.toUpperCase();

		// get rid of error cases first...
		if (letter.length() != 1) {
			return "Please guess a single letter.";
		}

		// get rid of another error case
		if (this.wrongLettersGuessed.contains(letter)) {
			return ("You already guessed that letter (and it was wrong then). Try again.");
		}

		// get rid of another error case
		if (this.revealWord.contains(letter)) {
			return ("You already guessed that letter. It was right, but still... Try again.");
		}

		if (this.hiddenWord.contains(letter)) {
			// They guessed a letter (that they have not already guessed) and
			// that letter is in the hiddenWord.
			// Copy over the correct letter(s) from hiddenWord to revealWord. 
			// Every instance of that letter is revealed. For example, if 
			// were two As in hiddenWord, then both of these As would be 
			// revealed.
			String newRevealWord = "";
			for (int i = 0; i< hiddenWord.length(); i++) {
				if (hiddenWord.substring(i, i+1).equalsIgnoreCase(letter)) {
					newRevealWord= newRevealWord+hiddenWord.substring(i,i+1);
				} else {
					newRevealWord=newRevealWord+revealWord.substring(i,i+1);
				}
			}
			revealWord = newRevealWord;
			return ("You are CORRECT! " + letter + " was found.");		
		}

		// if you are still here, your letter was not in the word (mistake)
		this.wrongLettersGuessed += letter;
		return "Sorry, wrong guess.";
	}

	public String getWrongLettersGuessed() {
		return this.wrongLettersGuessed;
	}

	public boolean hasWon () {
		return (!this.revealWord.contains("*"));
	}

	public boolean hasLost() {
		return (this.wrongLettersGuessed.length() >= MAX_WRONG_GUESSES);
	}

	public String getRevealWord () {
		return this.revealWord;
	}

	public String getHiddenWord () {
		return this.hiddenWord;
	}
	public void setHiddenWord(String newHiddenWord) {
        this.hiddenWord = newHiddenWord.toUpperCase();
        this.revealWord = "";
        for (int i = 0; i < newHiddenWord.length(); i++) {
            this.revealWord += "*";
        }
    }

	// I wrote this method when I first started implementing Hangman. 
	// This method shows that the Hangman constructor does get a new 
	// random animal every time a Hangman object is created and
	// it should show (once you fix the printHangman method) the 
	// hangman being "built", piece by piece: head first, then 
	// neck, then arms, then torso, then legs. 
	public void temporaryTester ( ) {
		System.out.println("Hidden word is "+this.hiddenWord);
		System.out.println("Reveal word is "+this.revealWord);
		for (int i = 0; i <= MAX_WRONG_GUESSES; i++) {

			// the length of wrongLettersGuessed determines how many body
			// parts the hangman should have. One letter means head only. 
			// two letters means head and neck, etc. 
			// The letter added, "q", is irrelevant...
			this.wrongLettersGuessed += "q"; 
			this.printHangman();
		}
		this.wrongLettersGuessed = ""; // set it back to what it should be (no wrong guesses)
	}

	// Print a picture of a hangman based on how many wrong letters have been 
	// guessed so far. 
	//   If 0 wrong letters guessed, print nothing. 
	//   If 1 wrong letters guessed, print just the head. 
	//   If 2, then print head and neck. 
	//   If 3, then head, neck and arms
	//   If 4, then head, neck, arms and torso
	//   If 5, then head, neck, arms, torso and legs.

	// Right now this method always prints a full hangman. It needs more logic
	// to print only the correct part of the hangman.
	public void printHangman () {

		int numWrong = this.wrongLettersGuessed.length();

		if(numWrong==1){ 
			System.out.println("               _");
			System.out.println("              ( )");    // head
		}
		else if(numWrong==2){
			System.out.println("               _");
			System.out.println("              ( )");
			System.out.println("               |");     // neck
		}
		else if(numWrong==3){
			System.out.println("               _");
			System.out.println("              ( )");
			System.out.println("               |");
			System.out.println("            === ===");  // arms
		}
		else if(numWrong==4){
			System.out.println("               _");
			System.out.println("              ( )");
			System.out.println("               |");
			System.out.println("            === ===");
			System.out.println("               |");     // torso
		}
		else if(numWrong==5){
			System.out.println("               _");
			System.out.println("              ( )");
			System.out.println("               |");
			System.out.println("            === ===");
			System.out.println("               |"); 
			System.out.println("              / \\ ");  // legs
			System.out.println("             /   \\ "); // because \ is an 'escape character', we needed 2 \s to print one \      
			System.out.println();     
		}
	}
}