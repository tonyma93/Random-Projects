package lab8_lists_intro;
import common.MyScanner;
public class Ma_List_Intro {	/* Program written by Tony Ma on 11/7/16
 * This program shows a list of gym memberships and its price,
 * and lets the user find specific details about the list. */

	static String [] gymName= { "Golds ","LA Fitness ","Crunch ","Retro ","YMCA ","Planet Fitness "};
	static double [] membershipPrice = {45,50,30,80,100,25};
	static final int NOT_FOUND = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyScanner keyboard = new MyScanner ();
		String choose = "";
		boolean option = true;
		while (option){
			System.out.println();
			System.out.println("Enter PA=Print All, PR=Print in Range, "
					+ "T=Total, A=Average, S=Smallest, L=Largest, F"
					+ "=Find or Q=Quit: ");
			choose = keyboard.nextString();
			if(choose.equalsIgnoreCase("PA")){
				printData();
			}
			else if(choose.equalsIgnoreCase("PR")){
				double lowRange=keyboard.nextDouble("Please enter the low range:");
				double highRange=keyboard.nextDouble("Please enter the high range: ");
				printRange(lowRange,highRange);

			}
			else if(choose.equalsIgnoreCase("T")){
				double total=totalSum();
				System.out.println("The total price for all gyms is: $"+total);
			}
			else if(choose.equalsIgnoreCase("A")){
				double average= averageSum();
				System.out.println("The average price for the listed gyms is: $"+average);
			}
			else if(choose.equalsIgnoreCase("S")){
				int low=lowestNumber();
				System.out.println("The lowest price is: "+gymName[low]+"$" +membershipPrice[low]);
			}
			else if(choose.equalsIgnoreCase("L")){
				int highest=highestNumber();
				System.out.println("The highest price is: "+gymName[highest]+"$" +membershipPrice[highest]);
			}
			else if(choose.equalsIgnoreCase("F")){
				String cont="y";
				while(cont.equalsIgnoreCase("y")){
					System.out.println();
					System.out.println("Please enter the name of the gym:" );
					String findName=keyboard.nextString();
					int foundSpot=findSpot(findName);
					if(foundSpot==NOT_FOUND){
						System.out.println("Sorry,"+findName+" not found");
					}
					System.out.println();
					System.out.println("Search again? Y/N");
					cont= keyboard.nextString();
				}
			}
			else if(choose.equalsIgnoreCase("Q")){
				System.out.println("All done");
				option=false;
			}
		}
	}
	public static void printData(){
		System.out.println();
		System.out.println("Gym Membership Data");
		System.out.println("-------------");
		for (int i = 0;i < gymName.length;i++){
			System.out.println(gymName[i]+" price is  $: "+ membershipPrice[i]);
		}

	}
	public static void printRange(double low,double high){
		for (int i = 0; i < membershipPrice.length;i++){
			if(membershipPrice[i] > low && membershipPrice[i]<high){
				System.out.println(gymName[i]+ "price is :$ "+ membershipPrice[i]);
			}

		}
	}
	public static double totalSum(){
		double total=0;
		for (int i = 0;i < membershipPrice.length;i++){
			total = total + membershipPrice[i];
		}
		return total;
	}
	public static double averageSum(){
		double sum=0;
		for (int i = 0;i < membershipPrice.length;i++){
			sum = sum + membershipPrice[i];
		}
		return sum / membershipPrice.length;
	}
	public static int lowestNumber(){
		int lowestIndex=0;
		for (int i = 0;i < membershipPrice.length;i++){
			if (membershipPrice[i]<membershipPrice[lowestIndex]){
				lowestIndex=i;
			}	
		}
		return lowestIndex;
	}
	public static int highestNumber(){
		int highestIndex=0;
		for (int i=0;i < membershipPrice.length;i++){
			if (membershipPrice[i] > membershipPrice[highestIndex]){
				highestIndex = i;
			}
		}
		return highestIndex;

	}
	public static int findSpot(String nameContains){
		if(nameContains.length()==0){
			return NOT_FOUND;
		}
		for (int i=0;i<gymName.length;i++){
			if(startsWith(gymName[i],nameContains)){
				System.out.println(gymName[i]+"price is:$"+ membershipPrice[i]);
				return i;
			}
		}
		return NOT_FOUND;
	}
	public static boolean startsWith(String bigString,String smallString){
		bigString = bigString.toUpperCase();
		smallString = smallString.toUpperCase();
		int i = bigString.indexOf(smallString);
		if (i < 0) {
			return false;  
		} else if (i == 0) {
			return true;   
		} else {
			return false;   
		}
	}
}
