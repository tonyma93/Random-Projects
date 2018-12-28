package lab4_methods;
import common.MyScanner;
public class Ma_Methods {
	/* Program written by Tony Ma on 9/28/2016  
	 * This program will calculate the price
	 * for someone going to a movie theater  */
	public static void main(String[] args) {
		//declarations

		String movieType = ""; //What movie ticket does the user want?
		int qtyMovie = 0; //How many tickets?
		final int horrorMoviePrice = 9;//price of horror movie
		final int comedyMoviePrice = 8;// price of comedy movie
		String myMessage=""; // purchase message

		//second set of declarations
		String broMovieType = "";//What movie ticket does the brother want?
		int broQtyMovie = 0; //How many tickets?
		String partTwoMessage="";//brother purchase message
		MyScanner keyboard = new MyScanner ();//gather input

		System.out.print("Would you like a horror or comedy ticket?");
		movieType = keyboard.nextString();
		if (movieType.equalsIgnoreCase("horror")){
			System.out.print("How many tickets would you like?");
			qtyMovie= keyboard.nextInt();
		}
		else if (movieType.equalsIgnoreCase("comedy")){
			System.out.print("How many tickets would you like?");
			qtyMovie = keyboard.nextInt();
		}
		//second input from user
		System.out.print("Does your brother want a horror or comedy ticket?");
		broMovieType = keyboard.nextString();
		if(broMovieType.equalsIgnoreCase("horror")){
			System.out.print("How many tickets would he like?");
			broQtyMovie= keyboard.nextInt();
		}
		else if (broMovieType.equalsIgnoreCase("comedy")){
			System.out.print("How many tickets would he like?");
			broQtyMovie = keyboard.nextInt();
		}
		//call the method twice
		myMessage = calcMovieTotal(movieType, qtyMovie,horrorMoviePrice,comedyMoviePrice);
		partTwoMessage = calcMovieTotal(broMovieType, broQtyMovie, horrorMoviePrice, comedyMoviePrice);

		System.out.println("Your purchase: "+ myMessage);
		System.out.println("Brother's purchase: " + partTwoMessage);
	}//end of main method
	public static String calcMovieTotal
	(String movieName, int totalBought, int horrorPrice,int comedyPrice){
		//declarations 
		String horrorMessage = "";//message for horror movie
		int totalHorrorPrice = 0;//total of ticket*horror price
		String comedyMessage = "";//message for comedy movie
		int totalComedyPrice = 0;//total of ticket*comedy price
		String errorMessage = "";//if user missspells horror or comedy
		//if user enters horror movie
		if(movieName.equalsIgnoreCase("horror")){		
			totalHorrorPrice= totalBought*horrorPrice;
			horrorMessage = "Your "+ totalBought+ " "+movieName+ " tickets will cost $"
					+ totalHorrorPrice+ "($9 per ticket)";
			return horrorMessage;
		}
		//if user enters comedy movie
		else if (movieName.equalsIgnoreCase("comedy")){
			totalComedyPrice=totalBought*comedyPrice;
			comedyMessage = "Your "+ totalBought+" "+ movieName+ " tickets will cost $"
					+ totalComedyPrice+ "($8 per ticket)";
			return comedyMessage;
		}
		else {
			errorMessage = "error, invalid input"; 
			return errorMessage;
		}

	}//end of method movietotal
}
