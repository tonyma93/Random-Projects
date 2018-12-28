package lab2_if;
import common.MyScanner;
public class Ma_If {
	/* Program written by Tony Ma on 9/14/2016  
	 * This program will calculate the price
	 * for someone going to a movie theater        */
	public static void main(String[] args) {
		final int MOVIE_TICKET = 5;			//the fixed price for a movie ticket
		int popcorn = 0;					//bags of popcorn
		String movie = "";					//what type of movie
		double popcornPrice = 0;			//price of popcorn
		double totalAmt = 0;				//total amount due

		System.out.println();
		System.out.println("Lets go to the Movies");
		System.out.println("---------------------");
		System.out.println();

		MyScanner keyboard= new MyScanner ();			
		System.out.println("Would you like to watch a drama,comedy,or horror movie?");
		movie = keyboard.nextString();
		if(movie.equalsIgnoreCase("drama")){ //user wants a movie ticket
			System.out.print("How many bags of popcorn would you like?");
			popcorn = keyboard.nextInt();
			System.out.print("How much is the popcorn?");
			popcornPrice = keyboard.nextDouble();}
		else if (movie.equalsIgnoreCase("comedy")) {
			System.out.print("How many bags of popcorn would you like?");
			popcorn = keyboard.nextInt();
			System.out.print("How much is the popcorn?");
			popcornPrice = keyboard.nextDouble();
		}
		else{
			System.out.print("How many bags of popcorn would you like?");
			popcorn = keyboard.nextInt();
			System.out.print("How much is the popcorn?");
			popcornPrice = keyboard.nextDouble();}
		totalAmt = MOVIE_TICKET+ popcorn*popcornPrice; 
		System.out.println (); //print blank line
		System.out.print("The "+movie+ " movie ticket will cost $"+ MOVIE_TICKET+
				", the popcorn will cost $ " +popcornPrice*popcorn+
				", and your total is $ " +totalAmt+ ". Have a nice day!");
		keyboard.close();
	}
}
