package lab5_objects;
import common.MyScanner;
public class Ma_objects {
	/* Program written by Tony Ma on 10/6/16
	 * This program will calculate the total balance after 5 years 
	 * for two people's balances with their interest rates */
	public static void main(String[] args) {
		String name= ""; //first persons name
		double myBalance = 0;//first persons input balance
		double myInterestRate = 0;//first persons input interest rate
		String yourName="";//second persons name
		double yourBalance = 0;//second person input
		double yourInterestRate = 0;//second persons input interest rate
		
		MyScanner keyboard = new MyScanner ();//gather input
		//get user input
		System.out.print("What is your name?");
		name = keyboard.nextString();
		System.out.print("What is your starting balance?");
		myBalance = keyboard.nextDouble();
		System.out.print("What is your interest rate?");
		myInterestRate = keyboard.nextDouble();

		//get second input
		System.out.println("Second person input");
		System.out.print("What is your name?");
		yourName = keyboard.nextString();
		System.out.print("What is your starting balance?");
		yourBalance = keyboard.nextDouble();
		System.out.print("What is your interest rate?");
		yourInterestRate = keyboard.nextDouble();
		
		// Declare and initialize two Employee objects
		Interest_Rate firstPerson = new Interest_Rate ("Fred", 500, 0.1);
		Interest_Rate secondPerson = new Interest_Rate("Robert", 100, 0.2);
		System.out.println("After instantiation");
		System.out.println( firstPerson.toString());
		System.out.println( secondPerson.toString());
		System.out.println();

		//setter method
		Interest_Rate myBal = new Interest_Rate (name, myBalance, myInterestRate);
		Interest_Rate yourBal = new Interest_Rate (yourName, yourBalance, yourInterestRate);
		System.out.println("After testing all setter methods");
		System.out.println( myBal.toString());
		System.out.println( yourBal.toString());
		System.out.println();
	
		//modifier method
		myBal.updateBalance(5);
		yourBal.updateBalance(5);

		System.out.println("After testing the modifier method");
		System.out.println("In 5 years..");
		System.out.println( myBal.prettyString());
		System.out.println( yourBal.prettyString());

	}

}
