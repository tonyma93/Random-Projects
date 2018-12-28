package lab3_loops;
import common.MyScanner;
public class Ma_Loops {
	/* Program written by Tony Ma on 9/21/2016  
	 * This program will calculate the average age
	 * of male and female students      */
	public static void main(String[] args) {
		// Declarations


		int sumMale = 0;	//sum of ages of males
		int sumFemale = 0; //sum of ages of females
		int ageMale = 0; //user input for student's age
		int ageFemale = 0; //user input for student's age
		String more = "y"; //y if they want to continue 
		String gender =""; // gender of student
		double avgMaleTotal = 0; //average of male student ages
		double avgFemaleTotal=0; // average of female student ages
		int maleTotal= 0; //total number of male students 
		int femaleTotal= 0; //total number of female students


		System.out.println("Student Gender and Average Ages");
		System.out.println("------------------------------");


		MyScanner keyboard = new MyScanner();


		while (more.equalsIgnoreCase("y")) {
			System.out.println();
			System.out.print("Please enter the gender (m/f):");
			gender = keyboard.nextString();
			if(gender.equalsIgnoreCase("m")){
				System.out.println();
				System.out.print("How old is the student?: ");
				ageMale = keyboard.nextInt();
				sumMale = sumMale + ageMale;}//total sum of ages for males
			else if (gender.equalsIgnoreCase("f")){
				System.out.println();
				System.out.print("How old is the student?: ");
				ageFemale = keyboard.nextInt();
				sumFemale = sumFemale + ageFemale;}//total sum of ages for females
			else{				
				System.out.println();
				System.out.print("invalid input ");}
			System.out.print("Do you want enter more (y/n)? ");
			more = keyboard.nextString();

		}
		System.out.println();
		System.out.println("How many male students were entered? ");
		maleTotal = keyboard.nextInt(); //find the # of male students entered
		System.out.println("How many female students were entered? ");
		femaleTotal = keyboard.nextInt(); //find the # of female students entered
		avgMaleTotal = sumMale/maleTotal; //calculates the avg age for males
		avgFemaleTotal = sumFemale/femaleTotal; //calculates the avg age for females

		System.out.println();
		System.out.println("The average age for " +maleTotal+" male students is " 
				+avgMaleTotal+ "years old");
		System.out.println("The average age for " +femaleTotal+" female students is " 
				+avgFemaleTotal+" years old");
		System.out.println();
	}

}