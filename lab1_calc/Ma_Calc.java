package lab1_calc;
import common.MyScanner;

public class Ma_Calc {
	/* Program written by Tony Ma on 9/7/2016
	 * This program will calculate how much interest you 
	 * accrue in a given amount of years             */

	public static void main(String[] args) {
		final double INTEREST_RATE = 0.1; // Bank interest rate per year (on initial amt)
		int year = 0; // How many years do you want to save for
		double amount = 0; // Amount of money that you are saving
		String fullName = ""; // Your name
		double interestAccrued = 0; //Total interest accrued  

		MyScanner keyboard= new MyScanner ();

		// getting user input
		System.out.print("Please enter your name: ");
		fullName = keyboard.nextString();

		System.out.print("How much do you want to save?");
		amount = keyboard.nextDouble();

		System.out.print("How many years will you be saving for?");
		year = keyboard.nextInt();

		// This calculation will compute the interest accrued
		// by multiplying the years, amount, and interest rate
		interestAccrued = year * amount * INTEREST_RATE;

		//Displays total interest accrued
		System.out.println (); //print blank line
		System.out.print ("Hello "+fullName+", if you have $"+amount+ " then you will accrue $" 
				+interestAccrued+ " in interest over " +year+ " year(s)");

		keyboard.close();
	}
}
