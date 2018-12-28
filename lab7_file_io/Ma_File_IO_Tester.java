package lab7_file_io;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import common.MyScanner;
import lab7_file_io.Interest_Rate;
public class Ma_File_IO_Tester {
	/* Program written by Tony Ma on 10/6/16
	 * This program will show the text file of a persons balance and their interest rate
	 * It will then allow the user to insert a new object into that text file. */

	public static void main(String[] args) {// Look for this file in the same folder as your project.
		showFile("Tony1.txt");
		String userLines=getInputFromUser();
		System.out.print("The data is :" + userLines);
		insertFile("Tony1.txt","TonyCopy.txt",userLines);
		copyFile("TonyCopy.txt","Tony1.txt");
	}// end main method
	public static String getInputFromUser(){
		MyScanner keyboard = new MyScanner ();//gather input
		String newName="";//persons name
		double newBalance = 0;// person input
		double newInterestRate = 0;//persons input interest rate

		//get user input
		System.out.print("What is your name?");
		newName = keyboard.nextString();
		newBalance = keyboard.nextDouble("What is your starting balance?");
		newInterestRate = keyboard.nextDouble("What is your interest rate?");

		Interest_Rate newData = new Interest_Rate(newName,newBalance,newInterestRate);
		return newData.objectToLine();
	}
	public static void showFile(String fileName){//shows the file
		String line = "";
		System.out.println("Original Data from: " + fileName);
		try
		{
			Scanner inputStream = new Scanner (new File (fileName));

			while(inputStream.hasNextLine())
			{
				line = inputStream.nextLine();
				System.out.println(line);
			}
			inputStream.close();
		}
		catch (Exception except)
		{
			System.out.println("Exception"+ except.getMessage());
		}
	}
	public static void copyFile(String inputFileName, String outputFileName){//copies file
		System.out.println("");
		MyScanner keyboard = new MyScanner ();
		String updateOriginal = "";
		System.out.print("Do you want to update your file? Y/N");
		updateOriginal = keyboard.nextString();
		if (updateOriginal.equalsIgnoreCase("y")){
			System.out.println("copied file, check Tony1.txt");
			String line = "";
			try
			{
				Scanner inputStream = new Scanner (new File (inputFileName));
				PrintWriter outputStream = new PrintWriter (outputFileName);

				while (inputStream.hasNextLine())
				{
					line=inputStream.nextLine();
					outputStream.println(line);
				}
				inputStream.close();
				outputStream.close();
			}
			catch (Exception except){
				System.out.println("Exception"+except.getMessage());
			}
		}
		else{
			System.out.print("You chose not to update your file. All done.");
		}
	}
	public static void insertFile(String inputFileName, String outputFileName, String userLine){//insert
		System.out.println();
		String line = "";
		try{
			Scanner inputStream = new Scanner ( new File (inputFileName));
			PrintWriter outputStream = new PrintWriter(new File (outputFileName));

			boolean statement = true;
			while (inputStream.hasNext()){
				line=inputStream.nextLine();

				int compare=line.compareTo(userLine);

				if (compare > 0 && statement ==true){
					outputStream.println(userLine);
					statement=false;
				}
				outputStream.println(line);
			}
			inputStream.close();
			outputStream.close();
		}
		catch (Exception except){
			System.out.println("not found");
		}
	}
}


